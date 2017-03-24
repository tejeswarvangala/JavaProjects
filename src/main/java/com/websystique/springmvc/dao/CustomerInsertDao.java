package com.websystique.springmvc.dao;

import java.util.Map;

import com.websystique.springmvc.model.Customer;

public interface CustomerInsertDao {
	public boolean insertCustomers(Customer cust);

	Map<String, Integer> retrieveCategoryCount();

}
