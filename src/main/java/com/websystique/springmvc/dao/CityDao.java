package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.City;

public interface CityDao {
   public List<City> getAllCities();
   public List<City> getCitiesByCountryCode(String CountryCode);
}
