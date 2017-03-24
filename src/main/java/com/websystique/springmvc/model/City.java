package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String cityName;

	@Column(name = "District")
	private String district;

	@Column(name = "CountryCode")
	private String countryCode;

	@Column(name = "Population")
	private int population;

	public City() {

	}

	public City(int id, String cityName, String district, String countryCode, int population) {
		this.id = id;
		this.cityName = cityName;
		this.district = district;
		this.countryCode = countryCode;
		this.population = population;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", district=" + district + ", countryCode=" + countryCode
				+ ", population=" + population + "]";
	}

}
