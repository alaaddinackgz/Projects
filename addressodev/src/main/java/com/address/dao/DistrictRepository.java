package com.address.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.District;

public interface DistrictRepository extends JpaRepository<District, Long>{

}
