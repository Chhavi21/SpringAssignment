package com.assignment.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assignment.dao.CountryDao;
import com.assignment.model.Country;

@Service
public class CountryService {
	private final static int PAGESIZE = 10;
	
	@Autowired
	CountryDao countryDao;


	
	public List<Country> findAllCountries() {
		List<Country> countries = countryDao.getAllCountries();
		return countries;
	}
	public List<Country> getPage(int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "name");
		
//		return countryRepo.findAll(request).getContent();
		return null;
	}
	public Country findByName(String name) {
		return countryDao.select(name);
	}

	public boolean isCountryExist(Country country) {
		List<String> countryNames = countryDao.getCountryNames();
		for (String countryName : countryNames) {
			if (countryName.equals(country.getName()))
				return true;
		}
		return false;
	}

	public void saveCountry(Country country) {
		if (country.getName()==null)
			countryDao.addCountry(country);
		else 
			countryDao.update(country);
	}

	public void updateCountry(Country currentCountry) {
		countryDao.update(currentCountry);

	}


	public void deleteCountryByName(String name) {
		countryDao.delete(name);

	}

}
