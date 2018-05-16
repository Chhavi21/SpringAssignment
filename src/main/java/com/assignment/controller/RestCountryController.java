package com.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.assignment.errorhandle.CustomErrorType;
import com.assignment.model.Country;
import com.assignment.service.CountryService;

@RestController
@RequestMapping(value = "/rest")
public class RestCountryController {

	public static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	CountryService countryService;

	// -------------------Retrieve All
	// Country---------------------------------------------
	@RequestMapping(value = "/country/", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountries() {
		logger.info("List all Country");
		List<Country> countries = countryService.findAllCountries();
		if (countries.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single Country------------------------------------------

	@RequestMapping(value = "/country/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getCountry(@PathVariable("name") String name) {
		logger.info("Fetching Country with name {}", name);
		Country country = countryService.findByName(name);
		if (country == null) {
			logger.error("Country with name {} not found.", name);
			return new ResponseEntity(new CustomErrorType("Country with name " + name + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	// -------------------Create a
	// Country-------------------------------------------

	@RequestMapping(value = "/country/", method = RequestMethod.POST)
	public ResponseEntity<?> createCountry(@RequestBody Country country, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Country : {}", country);
		if (countryService.isCountryExist(country)) {
			logger.error("Unable to create a country with name {} already exist", country.getName());
			return new ResponseEntity(
					new CustomErrorType("Unable to create country with name " + country.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		countryService.saveCountry(country);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/rest/country/{name}").buildAndExpand(country.getName()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/country/putAll/", method = RequestMethod.POST)
	public ResponseEntity<?> createCountry(@RequestBody List<Country> countries, UriComponentsBuilder ucBuilder) {

		for (Country country : countries) {
			if (countryService.isCountryExist(country)) {
				logger.error("Unable to create a country with name {} already exist", country.getName());
				return new ResponseEntity(
						new CustomErrorType(
								"Unable to create country with name " + country.getName() + " already exist."),
						HttpStatus.CONFLICT);
			}
			countryService.saveCountry(country);
		}
		return new ResponseEntity<String>( HttpStatus.CREATED);
	}
	
	// ------------------- Update a User
	// ------------------------------------------------

	@RequestMapping(value = "/country/{name}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCountry(@PathVariable("name") String name, @RequestBody Country country) {
		logger.info("Updating Country with name {}", name);

		Country currentCountry = countryService.findByName(name);

		if (currentCountry == null) {
			logger.error("Unable to update. Country with name {} not found.", name);
			return new ResponseEntity(new CustomErrorType("Unable to update country with name " + name + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCountry.setName(country.getName());
		currentCountry.setAlpha2Code(country.getAlpha2Code());
		currentCountry.setAlpha3Code(country.getAlpha3Code());
		currentCountry.setArea(country.getArea());
		currentCountry.setCapital(country.getCapital());
		currentCountry.setDemonym(country.getDemonym());
		currentCountry.setGini(country.getGini());
		currentCountry.setNativeName(country.getNativeName());
		currentCountry.setNumericCode(country.getNumericCode());
		currentCountry.setPopulation(country.getPopulation());
		currentCountry.setRegion(country.getRegion());
		currentCountry.setRelevance(country.getRelevance());
		currentCountry.setSubregion(country.getSubregion());
		currentCountry.setTranslations(country.getTranslations());
		countryService.updateCountry(currentCountry);
		return new ResponseEntity<Country>(currentCountry, HttpStatus.OK);
	}

	@RequestMapping(value = "/country/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Country> deleteCountry(@PathVariable("name") String name) {
		logger.info("Deleting Coutry {}", name);

		countryService.deleteCountryByName(name);
		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}

}
