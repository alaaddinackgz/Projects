package com.address.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.address.dao.CountryRepository;
import com.address.exception.CountryNotFoundException;
import com.address.model.Country;

@RestController
public class CountryController {

	private final CountryRepository countryRepository;

	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@GetMapping("/countries")
	List<Country> all(){
		return countryRepository.findAll();
	}
	
	@GetMapping("/country/{id}")
	Country getCountryById(@PathVariable Long id) {
		
		return countryRepository.findById(id).get();
				//orElseThrow(() -> new CountryNotFoundException(id));
	}
	
	@PostMapping("/country")
	Country newCountry(@RequestBody Country newCountry) {
	    return countryRepository.save(newCountry);
	  }
	
	
	/*@GetMapping("/countryy/{id}/{countycode}/{countyname}")
	Country getCountryParam(@PathVariable Long id,String countycode,String countyname) {
		
		Country addCountry = new Country();
		
		//addCountry.setId(4L);
		addCountry.setCounty_code(countyname);
		addCountry.setCountry_name(countyname);
		
		System.out.println("------->" + addCountry.getId());
		
		newCountry(addCountry);
		return countryRepository.findById(id).get();
		
	}
	
	*/
	
	/*//@PutMapping("/country/{id}/{countycode}/{countyname}")
	@RequestMapping(value = "/country/{id}/{countycode}/{countyname}", method = RequestMethod.GET)
	@ResponseBody
	Country addCountry(@RequestParam Long id,String countycode,String countyname ) {
		
		Country addCountry = new Country();
		
		addCountry.setId(id);
		addCountry.setCounty_code(countyname);
		addCountry.setCountry_name(countyname);
		
	    return countryRepository.save(addCountry);
	  }
	
	*/
	
	/* olmadı
	@DeleteMapping("/deletecountry/{id}")
	void deleteCity(@PathVariable Long id) {
		
		countryRepository.deleteById(id);
	}
	
	@RequestMapping(value="/country/delete/{id}",method = RequestMethod.POST)
	public void handleFormSubmit(@PathVariable long id) {
		countryRepository.deleteById(id);
	}
	*/
}
