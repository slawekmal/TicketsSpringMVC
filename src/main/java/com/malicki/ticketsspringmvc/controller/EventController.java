package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.model.Event;
import com.malicki.ticketsspringmvc.service.EventService;
import com.malicki.ticketsspringmvc.service.PlaceService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/", method = RequestMethod.GET)
public class EventController {

    private EventService eventService;
    private PlaceService placeService;

    @Autowired(required = true)
    @Qualifier(value = "eventService")
    public void setEventService(EventService es) {
        this.eventService = es;
    }
    
        @Autowired(required = true)
    @Qualifier(value = "placeService")
    public void setPlaceService(PlaceService es) {
        this.placeService = es;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", this.eventService.listEvents());
        model.addAttribute("listPlaces", this.placeService.listPlaces());
        return "event";
    }

    //For add and update event both
    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") Event e, @RequestParam("placeId") int placeId/*, @RequestParam("date") @DateTimeFormat(pattern="yyyy-mm-dd") Date date*/) throws ParseException {

//        Calendar calDate = Calendar.getInstance();
//        calDate.setTime(date);
//        e.setDate(calDate);
        e.setPlace(this.placeService.getPlaceById(placeId));
        if (e.getId() == 0) {
            //new event, add it
            this.eventService.addEvent(e);
        } else {
            //existing event, call update
            this.eventService.updateEvent(e);
        }

        return "redirect:/events";

    }

    @RequestMapping("/events/remove/{id}")
    public String removeEvent(@PathVariable("id") int id) {

        this.eventService.removeEvent(id);
        return "redirect:/events";
    }

    @RequestMapping("/events/edit/{id}")
    public String editEvent(@PathVariable("id") int id, Model model) {
        model.addAttribute("event", this.eventService.getEventById(id));
        model.addAttribute("listEvents", this.eventService.listEvents());
        model.addAttribute("listPlaces", this.placeService.listPlaces());
        return "event";
    }
}
