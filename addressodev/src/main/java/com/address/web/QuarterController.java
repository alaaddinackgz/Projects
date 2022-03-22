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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.QuarterRepository;
import com.address.dao.QuarterRepositoryJpa;
import com.address.model.City;
import com.address.model.District;
import com.address.model.Quarter;

@RestController
public class QuarterController {

	private final QuarterRepository quarterRepository;
	
	@Autowired
	private QuarterRepositoryJpa quarterRepositoryJpa;
	
	public QuarterController(QuarterRepository quarterRepository) {
		this.quarterRepository = quarterRepository;
	}
	
	@PostMapping("/quarter")
	Quarter newQuarter(@RequestBody Quarter quarter) {
		
		return quarterRepository.save(quarter);
	}
	
	 @PutMapping("/quarter/{id}")
	 Quarter replaceQuarter(@RequestBody Quarter newQuarter, @PathVariable Long id) {
	    
		 Optional<Quarter> newQuarterr = quarterRepository.findById(id);
	    	
		 return quarterRepository.findById(id)
			      .map(quarter -> {
			    	  quarter.setQuarterCode(newQuarter.getQuarterCode());
			    	  quarter.setQuarterName(newQuarter.getQuarterName());
			        return quarterRepository.save(quarter);
			      })
			      .orElseGet(() -> {
			    	  newQuarter.setId(id);
			        return quarterRepository.save(newQuarter);
			      });
	  }

	 @GetMapping("/quarter/{districtCode}")
	 Quarter getCityFindId(@PathVariable Long districtCode) {
			
			return quarterRepository.findById(districtCode).get();
		}

	 @GetMapping("quarter/districtcode/{districtCode}")
	 public ResponseEntity<List<Quarter>> getQuarterByDistrictCode(@PathVariable("districtCode") String districtCode){
		 
		 
		List<Quarter> quarter = quarterRepositoryJpa.findQurterByDistrictCode(districtCode);
		 
		return ResponseEntity.ok(quarter);
	 }
	
	 
	 @GetMapping("/quarters")
		List<Quarter> allQuarter(){
			return quarterRepository.findAll();
		}


}
