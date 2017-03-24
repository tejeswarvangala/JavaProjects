package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Country;
@Repository("countryDao")
public class CountryDaoImpl extends AbstractDao<Integer, Country> implements CountryDao {

	@SuppressWarnings("unchecked")
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
Criteria criteria = createEntityCriteria().addOrder( Order.asc("countryName") );
		
		return (List<Country>) criteria.list();
	}

}
