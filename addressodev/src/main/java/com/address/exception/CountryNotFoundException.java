package com.address.exception;

public class CountryNotFoundException extends RuntimeException {

	CountryNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
}
