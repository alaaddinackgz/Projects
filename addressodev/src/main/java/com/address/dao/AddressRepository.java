package com.address.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
