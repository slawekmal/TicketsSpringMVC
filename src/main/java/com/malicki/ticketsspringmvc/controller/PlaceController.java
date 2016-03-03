package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.model.Place;
import com.malicki.ticketsspringmvc.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/", method = RequestMethod.GET)
public class PlaceController {

    private PlaceService placeService;

    @Autowired(required = true)
    @Qualifier(value = "placeService")
    public void setPlaceService(PlaceService es) {
        this.placeService = es;
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public String listPlaces(Model model) {
        model.addAttribute("place", new Place());
        model.addAttribute("listPlaces", this.placeService.listPlaces());
        return "place";
    }

    //For add and update Place both
    @RequestMapping(value = "/places/add", method = RequestMethod.POST)
    public String addPlace(@ModelAttribute("place") Place p) {

        if (p.getId() == 0) {
            //new Place, add it
            this.placeService.addPlace(p);
        } else {
            //existing Place, call update
            this.placeService.updatePlace(p);
        }

        return "redirect:/places";

    }

    @RequestMapping("/places/remove/{id}")
    public String removePlace(@PathVariable("id") int id) {

        this.placeService.removePlace(id);
        return "redirect:/places";
    }

    @RequestMapping("/places/edit/{id}")
    public String editPlace(@PathVariable("id") int id, Model model) {
        model.addAttribute("place", this.placeService.getPlaceById(id));
        model.addAttribute("listPlaces", this.placeService.listPlaces());
        return "place";
    }
}
