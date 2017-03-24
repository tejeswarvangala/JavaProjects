package com.websystique.springmvc.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Customer;
@Repository("customerDao")
public class CustomerInsertDaoImpl extends AbstractDao<Integer, Customer> implements CustomerInsertDao {

	public boolean insertCustomers(Customer cust) {
		persist(cust);
		return true;
	}

	public Map<String, Integer> retrieveCategoryCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
