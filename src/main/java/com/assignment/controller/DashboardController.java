package com.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DashboardController {

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("login");
    	return model;
    }
	
//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public ModelAndView dashboard() {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("dashboard");
//    	return model;
//    }

//    @RequestMapping(value = "/app/login", method = RequestMethod.GET)
//    public ModelAndView login() {
//    	ModelAndView model = new ModelAndView();
//    	model.setViewName("login");
//    	return model;
//    }
    

}
