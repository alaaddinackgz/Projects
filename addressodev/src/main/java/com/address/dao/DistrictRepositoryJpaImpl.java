package com.address.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.address.model.District;

@Repository("districtRepositoryJpa")
public class DistrictRepositoryJpaImpl implements DistrictRepositoryJpa{

	@PersistenceContext
	private EntityManager entityManager;
	
	

	@Override
	public List<District> findDistrict(Long numberPlate) {
		
		return entityManager.createQuery(" from District where number_plate = :numberPlate", District.class).setParameter("numberPlate", numberPlate).getResultList();
	}

}
