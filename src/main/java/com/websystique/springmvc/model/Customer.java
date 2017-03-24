package com.websystique.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "CUST_FNAME")
	private String customerFname;
	
	@Column(name = "CUST_LNAME")
	private String customerLname;
	
	@Column(name = "CUST_EMAIL")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CUST_DOB")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dob;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "CUST_JOINDATE", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate doj;

	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerFname=" + customerFname + ", customerLname="
				+ customerLname + ", dob=" + dob.toString() + ", doj=" + doj.toString() + ", category=" + category + ", city=" + city + "]";
	}

	@Column(name = "category")
	private String category;
	
	public Customer(){
		
	}
	public Customer(int customerId, String customerFname, String customerLname, LocalDate dob, LocalDate doj, String category, City city, Country country){
		this.customerId=customerId;
		this.customerFname=customerFname;
		this.customerLname=customerLname;
		this.dob=dob;
		this.doj=doj;
		this.category=category;
		this.city=city;
		this.country=country;
		}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@OneToOne(fetch = FetchType.LAZY)
	private City city;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Country country;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFname() {
		return customerFname;
	}

	public void setCustomerFname(String customerFname) {
		this.customerFname = customerFname;
	}

	public String getCustomerLname() {
		return customerLname;
	}

	public void setCustomerLname(String customerLname) {
		this.customerLname = customerLname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
