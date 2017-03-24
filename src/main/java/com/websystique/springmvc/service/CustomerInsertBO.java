package com.websystique.springmvc.service;

import java.sql.SQLException;
import java.util.Map;

import com.websystique.springmvc.model.Customer;

public interface CustomerInsertBO {
	public boolean insertCustomers(Customer cust) throws ClassNotFoundException, SQLException;
	Map<String,Integer> retrieveCategoryCount() throws ClassNotFoundException, SQLException;
}
