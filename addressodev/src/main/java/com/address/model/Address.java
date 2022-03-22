package com.address.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

	
	@Id
	@GeneratedValue(generator="Address")
	@SequenceGenerator(name="Address",sequenceName="ADDRESS_ID_SEQ")
    private Long id;
	
	 @Column(name="Country_Code")
	 private String county_code;
	 
	 @Column(name="number_plate")
	 private Long numberPlate;
	 
	 @Column(name="district_code")
	 private String districtCode;
	 
	 @Column(name="quarter_code")
	 private String quarterCode;
	 
	 @Column(name="street_code")
	 private String streetCode;
	 
	 @Column(name="gate_no")
	 private String gateNo;
	 
	 @Column(name="apartment_no")
	 private String apartmentNo;
	 
	 
	 /*//@ManyToOne()
	 //@JoinColumn(name="Country_Code", insertable = false, updatable = false)
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinTable(name = "Country_x", joinColumns = { @JoinColumn(name = "Country_Code") }, inverseJoinColumns = { @JoinColumn(name = "Country_Code") })
	 private Country country;

	//@OneToMany
	//@JoinColumn(name="Country_Code")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	*/
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCounty_code() {
		return county_code;
	}

	public void setCounty_code(String county_code) {
		this.county_code = county_code;
	}

	public Long getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(Long numberPlate) {
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

	public String getGateNo() {
		return gateNo;
	}

	public void setGateNo(String gateNo) {
		this.gateNo = gateNo;
	}

	public String getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
	 
	
}
