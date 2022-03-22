package com.address.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.CityRepository;
import com.address.model.City;

@RestController
public class CityController {

	private final CityRepository cityRepository;
	
	public CityController(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	@GetMapping("/cities")
	List<City> all(){
		
		return cityRepository.findAll();
	}
	
	@GetMapping("/city/{numberPlate}")
	City getCityFindId(@PathVariable Long numberPlate) {
		
		return cityRepository.findById(numberPlate).get();
	}
	
	@PostMapping("/city")
	City newCity(@RequestBody City newCity) {
		
		return cityRepository.save(newCity);
	}
	
	@DeleteMapping("/deletecity/{id}")
	void deleteCity(@PathVariable Long id) {
		
		cityRepository.deleteById(id);
	}
	
}
