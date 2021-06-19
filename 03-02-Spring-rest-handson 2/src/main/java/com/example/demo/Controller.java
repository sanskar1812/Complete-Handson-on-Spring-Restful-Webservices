package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping(method = RequestMethod.GET,value ="/countries")			
	public List<Country> getallCountries(){
		SpringRestHandson2Application springrest= new SpringRestHandson2Application();
		return springrest.displayCountries();
	}
	@RequestMapping(method = RequestMethod.GET,value ="/country")			
	public Country getCountryIndia(){
		SpringRestHandson2Application springrest= new SpringRestHandson2Application();
		return springrest.displayCountry();
	}
}
