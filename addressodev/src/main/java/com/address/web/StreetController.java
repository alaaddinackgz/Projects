package com.address.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.StreetRepository;
import com.address.dao.StreetRepositoryJpa;
import com.address.model.Quarter;
import com.address.model.Street;

@RestController
public class StreetController {

	
	private final StreetRepository streetRepository;
	
	@Autowired
	private StreetRepositoryJpa streetRepositoryJpa;
	
	 public StreetController(StreetRepository streetRepository) {
		super();
		this.streetRepository = streetRepository;
	}

	 @PostMapping("/newstreet")
	 Street newStreet(@RequestBody Street street) {
		 
		 return streetRepository.save(street);
		 
	 }

	@GetMapping("/streets")
		List<Street> allStreet(){
			return streetRepository.findAll();
		}
	
	 @PutMapping("/street/{id}")
	 Street replaceStreet(@RequestBody Street newStreet, @PathVariable Long id) {
	    
		 Optional<Street> newStreett = streetRepository.findById(id);
	    	
		 return streetRepository.findById(id)
			      .map(street -> {
			    	  street.setStreetCode(newStreet.getStreetCode());
			    	  street.setStreetName(newStreet.getStreetName());
			        return streetRepository.save(street);
			      })
			      .orElseGet(() -> {
			    	  newStreet.setId(id);
			        return streetRepository.save(newStreet);
			      });
	  }
	 
	
	 @GetMapping("street/quartercode/{quarterCode}")
	 public ResponseEntity<List<Street>> getStreetByQuarterCode(@PathVariable("quarterCode") String quarterCode){
		 
		 List<Street> street = streetRepositoryJpa.getStreetByQuarterCode(quarterCode);
		 
		 return ResponseEntity.ok(street);
	 }

}
