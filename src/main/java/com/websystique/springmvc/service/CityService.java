package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.City;

public interface CityService {
	public List<City> getAllCities();
	public List<City> getCitiesByCountryCode(String countryCode);
}