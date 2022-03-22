package com.address.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.Street;

public interface StreetRepository extends JpaRepository<Street, Long>{

}
