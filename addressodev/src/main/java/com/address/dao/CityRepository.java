package com.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
