package com.address.dao;

import com.address.fnc.FncHepler;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.address.model.Street;

@Repository("streetRepositoryJpa")
public class StreetRepositoryJpaImpl implements StreetRepositoryJpa {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Optional<List<Street>> getStreetByQuarterCode(String quarterCode) {
		final TypedQuery<Street> query = entityManager.createQuery(
						"select s from Street s where s.quarterCode = :quarterCode", Street.class)
				.setParameter("quarterCode", quarterCode);
		return FncHepler.toSupplierOptional(query::getResultList);
	}

}
