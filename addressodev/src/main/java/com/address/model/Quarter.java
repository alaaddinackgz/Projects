package com.address.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Quarter")
public class Quarter {

	
	
	@Id
	@GeneratedValue(generator="Quarter")
	@SequenceGenerator(name="Quarter",sequenceName="QUARTER_ID_SEQ")
    private Long id;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="AddressSeq")
	@SequenceGenerator(name="AddressSeq",sequenceName="Address_sequence")
	private  Long id;
	*/
	
	// private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;
	 
	 @Column(name="number_plate")
	 private String numberPlate;
	 
	 @Column(name="district_code")
	 private String districtCode;
	 
	 @Column(name="quarter_code")
	 private String quarterCode;
	 
	 @Column(name="quarter_name")
	 private String quarterName;

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

	public String getQuarterName() {
		return quarterName;
	}

	public void setQuarterName(String quarterName) {
		this.quarterName = quarterName;
	}
	 
	 
}
