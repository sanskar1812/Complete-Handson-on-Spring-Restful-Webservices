package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

	@Autowired
	private CountryService countryService;

	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");
		LOGGER.debug("Calling getCountry() with method 'GET'");
		LOGGER.info("END");
		return (Country) context.getBean("in");
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		LOGGER.debug("Calling getAllCountries() with method 'GET'");
		LOGGER.info("END");
		return (List<Country>) context.getBean("countryList");
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		LOGGER.debug("Calling getCountry() with method 'GET' and code=" + code);
		LOGGER.info("END");
		return countryService.getCountry(code);
	}

	@PostMapping("/countries")
	public void addCountry(@Valid @RequestBody Country country) {
		LOGGER.info("START");
		LOGGER.debug("Added {}", country);
		LOGGER.info("END");
	}
}
