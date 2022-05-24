package com.address.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.address.model.Street;

@Repository("streetRepositoryJpa")
public class StreetRepositoryJpaImpl implements StreetRepositoryJpa {

	@PersistenceContext
	EntityManager entityManager;
	

	/*@Override
	public List<Street> getStreetByQuarterCode(String quarterCode) {
		
		
		return entityManager.createQuery(" from Street where QUARTER_CODE = :quarterCode",Street.class)
				.setParameter("quarterCode", quarterCode).getResultList().;
	}*/
	
	@Override
	public Optional<List<Street>> getStreetByQuarterCode(String quarterCode) {
		
		List<Street> streets = entityManager.createQuery(" from Street where QUARTER_CODE = :quarterCode",Street.class)
				.setParameter("quarterCode", quarterCode).getResultList();
		
		 if (streets.isEmpty()) {
		        return Optional.empty();
		    }
		    return Optional.of(streets);
	}
	
	

}
