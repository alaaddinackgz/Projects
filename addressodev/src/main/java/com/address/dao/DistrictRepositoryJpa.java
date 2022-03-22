package com.address.dao;

import java.util.List;

import com.address.model.District;

public interface DistrictRepositoryJpa {

	List<District> findDistrict(Long numberPlate);

}
