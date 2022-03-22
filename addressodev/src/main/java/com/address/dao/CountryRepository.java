package com.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
