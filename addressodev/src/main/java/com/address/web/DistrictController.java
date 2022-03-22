package com.address.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.DistrictRepository;
import com.address.dao.DistrictRepositoryJpa;
import com.address.model.District;

@RestController
public class DistrictController {

	private final DistrictRepository districtRepository;
	
	@Autowired
	private DistrictRepositoryJpa districtRepositoryJpa;
	
	public DistrictController(DistrictRepository districtRepository) {
		this.districtRepository = districtRepository;
	}
	
	@GetMapping("/districts")
	List<District> all(){
		return districtRepository.findAll();
	}
	
	@PostMapping("/save/district")
	District newDistrict(@RequestBody District newDistrict) {
		
		return districtRepository.save(newDistrict);
	}
	
	@GetMapping("/district/{numberplate}")
	District getDistrictFindById(@PathVariable Long numberplate) {
		
		return districtRepository.findById(numberplate).get();
	}
	
	//@RequestMapping(method=RequestMethod.GET,value="/districtt/{numberPlate}")
	@GetMapping("/city/district/{numberplate}")
	public ResponseEntity<List<District>> getDistrict(@PathVariable("numberplate") Long numberPlate){
		
	List<District> district = districtRepositoryJpa.findDistrict(numberPlate);
	return ResponseEntity.ok(district);
		
	} 
	
}
