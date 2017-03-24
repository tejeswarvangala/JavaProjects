package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.CityDao;
import com.websystique.springmvc.model.City;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
	@Autowired
	CityDao cityDao;

	public List<City> getAllCities() {
		return cityDao.getAllCities();
	}

	public List<City> getCitiesByCountryCode(String countryCode) {
		List<City> cities = cityDao.getCitiesByCountryCode(countryCode);
		return cities;
	}

}
