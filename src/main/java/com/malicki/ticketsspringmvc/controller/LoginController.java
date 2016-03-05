package com.malicki.ticketsspringmvc.controller;

import com.malicki.ticketsspringmvc.delegate.LoginDelegate;
import com.malicki.ticketsspringmvc.model.Client;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginDelegate loginDelegate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("login");
        Client client = new Client();
        model.addObject("client", client);
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("client") Client client) {
        ModelAndView model = null;
        try {
            boolean isValidUser = loginDelegate.isValidUser(client.getEmail(), client.getPassword());
            if (isValidUser) {
                System.out.println("User Login Successful");
                request.setAttribute("loggedInUser", client.getEmail());
                model = new ModelAndView("welcome");
            } else {
                model = new ModelAndView("login");
                model.addObject("client", client);
                request.setAttribute("message", "Invalid credentials!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
