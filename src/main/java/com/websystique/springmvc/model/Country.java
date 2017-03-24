package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@Column(name = "Code")
	private String countryCode;

	@Column(name = "countryName")
	private String countryName;

	@Column(name = "Region")
	private String region;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public Country(){
		
	}
	
	public Country(String countryCode, String name, String region){
		this.countryCode=countryCode;
		this.countryName=name;
		this.region=region;
	}



}
