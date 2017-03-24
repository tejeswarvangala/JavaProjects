package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.CountryDao;
import com.websystique.springmvc.model.Country;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService {
	@Autowired
	CountryDao countryDao;

	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();

	}

}
