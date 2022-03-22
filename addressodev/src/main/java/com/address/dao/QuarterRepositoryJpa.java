package com.address.dao;

import java.util.List;

import com.address.model.Quarter;



public interface QuarterRepositoryJpa {

	List<Quarter> findQurterByDistrictCode(String districtCode);
}
