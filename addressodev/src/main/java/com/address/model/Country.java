package com.address.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@GeneratedValue(generator="Country")
	@SequenceGenerator(name="Country",sequenceName="Country_ID_SEQ")
	 private  Long id;
	 
	 //GenerationType.IDENTITY
	
	 @Column(name="Country_Code")
	 private String county_code;
	 
	 @Column(name="Country_Name")
	 private String country_name;
	  

	  public Country() {}

	  Country(String country_name, String county_code) {

	    this.country_name = country_name;
	    this.county_code = county_code;
	  }
	  
	  @OneToMany(fetch = FetchType.LAZY)
	    // Bire çok iliski oldugunu belirtiyoruz.
	    // Burada Country tipinde Liste olusturuyoruz.
	    // Bunun nedeni bir kullanici birden fazla Country olusturabilecesi için
	    // Country'leri liste seklinde tutuyoruz.
	  @JoinColumn(name = "Country_Code")
	    // Order tablosuna eklenecek kolonun adini yaziyoruz
	  private Collection<Address> countryCode = new ArrayList<Address>();
	  
	public Collection<Address> getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Collection<Address> countryCode) {
		this.countryCode = countryCode;
	}


	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCounty_code() {
		return county_code;
	}

	public void setCounty_code(String county_code) {
		this.county_code = county_code;
	}
	  
	  
	
}
