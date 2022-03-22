package com.address.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.address.model.Quarter;

@Repository("quarterRepositoryJpa")
public class QuarterRepositoryJpaImpl implements QuarterRepositoryJpa {

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public List<Quarter> findQurterByDistrictCode(String districtCode) {
		
		return entityManager.createQuery(" from Quarter where DISTRICT_CODE = :districtCode",Quarter.class)
				.setParameter("districtCode", districtCode).getResultList();
	}

	

}
