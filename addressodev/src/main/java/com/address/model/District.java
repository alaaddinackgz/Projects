package com.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="District")
public class District {
	
	private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
	
	@Column(name="number_plate")
	private Long numberPlate;
	
	@Column(name="district_code")
	private String districtCode;
	
	
	@Column(name="district_name")
	private String districtName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(Long numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
