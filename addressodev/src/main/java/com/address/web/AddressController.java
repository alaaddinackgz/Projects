package com.address.web;



import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.AddressRepository;
import com.address.model.Address;

@RestController
public class AddressController {
	
	private final AddressRepository addressRepository; 
	
	public AddressController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	@GetMapping("/address")
	List<Address> all(){
		return addressRepository.findAll();
	}
	
	@PostMapping("/save/address")
	Address newAddress(@RequestBody Address newAddress) {
		
		return addressRepository.save(newAddress);
	}
	
	 @PutMapping("/address/{id}")
	 Address replaceAddress(@RequestBody Address newAddress, @PathVariable Long id) {
	    
		 Optional<Address> newAddress1 = addressRepository.findById(id);
	    	
		 return addressRepository.findById(id)
			      .map(address -> {
			    	  address.setGateNo(newAddress.getGateNo());
			    	  address.setApartmentNo(newAddress.getApartmentNo()); 
			        return addressRepository.save(address);
			      })
			      .orElseGet(() -> {
			    	  newAddress.setId(id);
			        return addressRepository.save(newAddress);
			      });
	  }
	 
	 @GetMapping("/address/find/{id}")
	 Address getAddressFindById(@PathVariable Long id) {
		
		 return addressRepository.findById(id).get();
	 }

}
