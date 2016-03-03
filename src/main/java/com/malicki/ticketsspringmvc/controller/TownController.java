package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.model.Town;
import com.malicki.ticketsspringmvc.service.TownService;
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
public class TownController {

    private TownService townService;

    @Autowired(required = true)
    @Qualifier(value = "townService")
    public void setTownService(TownService es) {
        this.townService = es;
    }

    @RequestMapping(value = "/towns", method = RequestMethod.GET)
    public String listTowns(Model model) {
        model.addAttribute("town", new Town());
        model.addAttribute("listTowns", this.townService.listTowns());
        return "town";
    }

    //For add and update Town both
    @RequestMapping(value = "/towns/add", method = RequestMethod.POST)
    public String addTown(@ModelAttribute("town") Town t) {

        if (t.getId() == 0) {
            //new Town, add it
            this.townService.addTown(t);
        } else {
            //existing Town, call update
            this.townService.updateTown(t);
        }

        return "redirect:/towns";

    }

    @RequestMapping("/towns/remove/{id}")
    public String removeTown(@PathVariable("id") int id) {

        this.townService.removeTown(id);
        return "redirect:/towns";
    }

    @RequestMapping("/towns/edit/{id}")
    public String editTown(@PathVariable("id") int id, Model model) {
        model.addAttribute("town", this.townService.getTownById(id));
        model.addAttribute("listTowns", this.townService.listTowns());
        return "town";
    }
}
