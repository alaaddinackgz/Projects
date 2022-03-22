package com.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class City {

	
	private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
	
	 @Column(name="number_plate")
	 private Long numberPlate;
	 

	@Column(name="city_name")
	 private String cityName;
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(Long numberPlate) {
		this.numberPlate = numberPlate;
	}
	
	
	
}
