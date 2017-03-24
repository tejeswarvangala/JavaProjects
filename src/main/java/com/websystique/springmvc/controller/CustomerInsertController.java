package com.websystique.springmvc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Country;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.service.CityService;
import com.websystique.springmvc.service.CountryService;
import com.websystique.springmvc.service.CustomerInsertBO;

@Controller
public class CustomerInsertController {
	@Autowired
	private CustomerInsertBO customerInsertBo;
	@Autowired
	private CityService cityService;
	@Autowired
	private CountryService countryService;
	@Autowired
	MessageSource messageSource;

	@RequestMapping("/customerInsert")
	public ModelAndView customerInsert() {
		List<Country> countries = countryService.getAllCountries();
		ModelMap model = new ModelMap();
		model.put("countries", countries);
		model.put("cust", new Customer());
		// return new ModelAndView("custInsert", "cust", new Customer());
		return new ModelAndView("custInsert", model);
	}

	@RequestMapping("/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("cust") Customer customer) {
		boolean insert = false;
		try {
			insert = customerInsertBo.insertCustomers(customer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/customerInsert");
	}
	
	@RequestMapping(value="/updateCities", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody List<City> updateCities(@RequestParam("countryCode") String countryCode) {
		return cityService.getCitiesByCountryCode(countryCode);
	}

}
