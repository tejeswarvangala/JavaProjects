package com.websystique.springmvc.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CustomerInsertDao;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.util.EmailUtility;
@Service("customerInsertBO")
@Transactional
public class CustomerInsertBOImpl  implements CustomerInsertBO {
	@Autowired
	private CustomerInsertDao customerDao;
	@Autowired
	private EmailUtility emailUtility;
	
	public boolean insertCustomers(Customer cust) throws ClassNotFoundException, SQLException {
		boolean result=customerDao.insertCustomers(cust);
		if(result){
			emailUtility.sendEmail(cust.getEmail(), "New Customer Added to My App", cust.toString());
		}
		return result;
	}

	public Map<String, Integer> retrieveCategoryCount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
