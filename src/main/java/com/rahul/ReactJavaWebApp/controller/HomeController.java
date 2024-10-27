package com.rahul.ReactJavaWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
//    @ResponseBody  //instead of that we could have used @RestController on top too..whole game is to setup RestAPI i.e sending state/data only from server to frontend instead of sending whole html layout
    public String greet(){
        System.out.println("Welcome to the homepage delivered from HomeController");
        return "Homepage from homecontroller";
    }
    @RequestMapping("/about")
    public String aboutHandler(){
        return "This is the about page";
    }
}
