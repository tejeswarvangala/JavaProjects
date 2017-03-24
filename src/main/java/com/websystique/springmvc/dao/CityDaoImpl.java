package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.City;

@Repository("cityDao")
public class CityDaoImpl extends AbstractDao<Integer, City> implements CityDao {

	@SuppressWarnings("unchecked")
	public List<City> getAllCities() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("cityName"));

		return (List<City>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<City> getCitiesByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().add(Restrictions.eq("countryCode", countryCode)).addOrder(Order.asc("cityName"));
		return (List<City>) criteria.list();
	}

}
