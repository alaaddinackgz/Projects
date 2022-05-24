package com.address.dao;

import java.util.List;
import java.util.Optional;

import com.address.model.Street;


public interface StreetRepositoryJpa {

	Optional<List<Street>> getStreetByQuarterCode(String quarterCode);

}
