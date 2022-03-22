package com.address.dao;

import java.util.List;

import com.address.model.Street;


public interface StreetRepositoryJpa {

	List<Street> getStreetByQuarterCode(String quarterCode);
}
