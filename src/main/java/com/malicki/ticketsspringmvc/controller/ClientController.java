package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.model.Client;
import com.malicki.ticketsspringmvc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/", method = RequestMethod.GET)
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String listclients(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("listClients", this.clientService.listClients());
        return "client";
    }

    //For add and update client both
    @RequestMapping(value = "/clients/add", method = RequestMethod.POST)
    public String addclient(@ModelAttribute("client") Client c) {

        if (c.getId() == 0) {
            //new client, add it
            this.clientService.addClient(c);
        } else {
            //existing client, call update
            this.clientService.updateClient(c);
        }

        return "redirect:/clients";

    }

    @RequestMapping("/clients/remove/{id}")
    public String removeclient(@PathVariable("id") int id) {

        this.clientService.removeClient(id);
        return "redirect:/clients";
    }

    @RequestMapping("/clients/edit/{id}")
    public String editclient(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClients());
        return "client";
    }
}
