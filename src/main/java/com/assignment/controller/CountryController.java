package com.assignment.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.assignment.model.Country;
import com.assignment.service.CountryService;

@RestController
@RequestMapping(value = "/app")
public class CountryController {
	private final static int PAGE_SIZE =5;
	public static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	CountryService countryService;

	// -------------------Show Countries---------------------------------------------
	@RequestMapping(value = {"/dashboard/{type}","/dashboard"}, method = RequestMethod.GET)
	public ModelAndView  getAllCountries(@PathVariable Map<String,String> pathVariableMap,HttpServletRequest req,ModelAndView model) {
		PagedListHolder<Country> productList = null;
		 String type = pathVariableMap.get("type");
		 if(type==null) {
			 List<Country> countryList = countryService.findAllCountries();
	            
	            productList = new PagedListHolder<Country>();
	            productList.setSource(countryList);
	            productList.setPageSize(PAGE_SIZE);
	            
	            req.getSession().setAttribute("countries",  productList);
	        
		 } else if("next".equals(type)) {
	            // Return next set of list
	            productList = (PagedListHolder<Country>) req.getSession()
	                                .getAttribute("countries");
	            
	            productList.nextPage();
	            
	            
	        } else if("prev".equals(type)) {
	            // Return previous set of list
	            productList = (PagedListHolder<Country>) req.getSession()
	                                .getAttribute("countries");
	            
	            productList.previousPage();
	            
	            
	        } else {
	            // Return specific index set of list
	            System.out.println("type:" + type);
	            
	            productList = (PagedListHolder<Country>) req.getSession()
	                                .getAttribute("countries");
	            
	            int pageNum = Integer.parseInt(type);
	            
	            productList.setPage(pageNum);
	            
	        }
		model.setViewName("dashboard");
		return model;
	}
	// -------------------Show new country---------------------------------------------
	@RequestMapping(value = "/addCountry", method = RequestMethod.GET)
	public ModelAndView newCountry(ModelAndView model) {
	    Country newCountry = new Country();
	    model.addObject("country", newCountry);
	    model.setViewName("CountryForm");
	    return model;
	}
	// -------------------insert or update Country------------------------------------------

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public ModelAndView saveCountry(@ModelAttribute Country country) {
		logger.info(" Saving  in DB : "+ country.getName());
		countryService.saveCountry(country);
	    return new ModelAndView("redirect:/app/dashboard");
	}
	
	// -------------------Edit particular Country------------------------------------------ 
	@RequestMapping(value = "/editCountry", method = RequestMethod.GET)
	public ModelAndView editCountry(HttpServletRequest request) {
	    String countryName = request.getParameter("name");
	    Country country = countryService.findByName(countryName);
	    ModelAndView model = new ModelAndView("CountryForm");
	    model.addObject("country", country);
	 
	    return model;
	}
	// -------------------Delete Country------------------------------------------ 
	@RequestMapping(value = "/deleteCountry", method = RequestMethod.GET)
	public ModelAndView deleteCountry(HttpServletRequest request) {
	    String countryName = request.getParameter("name");
	    countryService.deleteCountryByName(countryName);
	    return new ModelAndView("redirect:/app/dashboard");
	}

}
