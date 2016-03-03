package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.model.Event;
import com.malicki.ticketsspringmvc.service.EventService;
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
public class EventController {

    private EventService eventService;

    @Autowired(required = true)
    @Qualifier(value = "eventService")
    public void setEventService(EventService es) {
        this.eventService = es;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String listEvents(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("listEvents", this.eventService.listEvents());
        return "event";
    }

    //For add and update event both
    @RequestMapping(value = "/events/add", method = RequestMethod.POST)
    public String addEvent(@ModelAttribute("event") Event e) {

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
        return "event";
    }
}
