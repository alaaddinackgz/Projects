package com.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Street")
public class Street {

 private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
	 
	 @Column(name="number_plate")
	 private String numberPlate;
	 
	 @Column(name="district_code")
	 private String districtCode;
	 
	 @Column(name="quarter_code")
	 private String quarterCode;
	 
	 @Column(name="street_code")
	 private String streetCode;
	 
	 @Column(name="street_name")
	 private String streetName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getQuarterCode() {
		return quarterCode;
	}

	public void setQuarterCode(String quarterCode) {
		this.quarterCode = quarterCode;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public void setStreetCode(String streetCode) {
		this.streetCode = streetCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	 
	 
	 
}
