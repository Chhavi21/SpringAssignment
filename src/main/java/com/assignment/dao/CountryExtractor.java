package com.assignment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.assignment.model.Country;
import com.assignment.model.Translations;

public class CountryExtractor implements ResultSetExtractor<Object> {

	@Override
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Country> map = new HashMap<String, Country>();
		
		while (rs.next()) {
			String name = rs.getString("name");
			Country country = map.get(name);
			if(country==null) {
				 country = new Country();
				country.setName(rs.getString("name"));
				country.setAlpha2Code(rs.getString("alpha2Code"));
				country.setAlpha3Code(rs.getString("alpha3Code"));
				country.setCapital(rs.getString("capital"));
				country.setRegion(rs.getString("region"));
				country.setSubregion(rs.getString("subregion"));
				country.setPopulation(rs.getInt("population"));
				country.setDemonym(rs.getString("demonym"));
				country.setArea(rs.getDouble("area"));
				country.setGini(rs.getDouble("gini"));
				country.setNativeName(rs.getString("nativeName"));
				country.setNumericCode(rs.getDouble("numericCode"));
				country.setRelevance(rs.getDouble("relevance"));
				map.put(name, country);
			}
			Translations translations = country.getTranslations();
			if (translations==null) {
				translations= new Translations();
				translations.setDe(rs.getString("de"));
				translations.setEs(rs.getString("es"));
				translations.setFr(rs.getString("fr"));
				translations.setIt(rs.getString("it"));
				translations.setJa(rs.getString("ja"));
				country.setTranslations(translations);;
			}
			
			java.util.List<String> languageList = country.getLanguages();
			if (languageList==null) {
				languageList= new ArrayList<String>();
				country.setLanguages(languageList);
			}
			if(!languageList.contains(rs.getString("languages")))
				languageList.add(rs.getString("languages"));
 
			java.util.List<String> currencyList = country.getCurrencies();
			if (currencyList==null) {
				currencyList= new ArrayList<String>();
				country.setCurrencies(currencyList);
			}
			if(!currencyList.contains(rs.getString("currencies")))
				currencyList.add(rs.getString("currencies"));
			
			java.util.List<String> timezoneList = country.getTimezones();
			if (timezoneList==null) {
				timezoneList= new ArrayList<String>();
				country.setTimezones(timezoneList);
			}
			if(!timezoneList.contains(rs.getString("timezones")))
				timezoneList.add(rs.getString("timezones"));
			
			java.util.List<String> callingCodeList = country.getCallingCodes();
			if (callingCodeList==null) {
				callingCodeList= new ArrayList<String>();
				country.setCallingCodes(callingCodeList);
			}
			if(!callingCodeList.contains(rs.getString("callingCodes")))
				callingCodeList.add(rs.getString("callingCodes"));
			
			java.util.List<Double> latlngList = country.getLatlng();
			if (latlngList==null) {
				latlngList= new ArrayList<Double>();
				country.setLatlng(latlngList);
			}
			if(!latlngList.contains(Double.parseDouble(rs.getString("latlng"))))
				latlngList.add(Double.parseDouble(rs.getString("latlng")));
			
			java.util.List<String> topLevelDomainList = country.getTopLevelDomain();
			if (topLevelDomainList==null) {
				topLevelDomainList= new ArrayList<String>();
				country.setTopLevelDomain(topLevelDomainList);
			}
			if(!topLevelDomainList.contains(rs.getString("topLevelDomain")))
			topLevelDomainList.add(rs.getString("topLevelDomain"));
			
			java.util.List<String> altSpellingList = country.getAltSpellings();
			if (altSpellingList==null) {
				altSpellingList= new ArrayList<String>();
				country.setAltSpellings(altSpellingList);
			}
			if(!altSpellingList.contains(rs.getString("altSpellings")))
			altSpellingList.add(rs.getString("altSpellings"));
			
			java.util.List<String> bordersList = country.getBorders();
			if (bordersList==null) {
				bordersList= new ArrayList<String>();
				country.setBorders(bordersList);
			}
			if(!bordersList.contains(rs.getString("borders")))
			bordersList.add(rs.getString("borders"));
		}
		return  new ArrayList<Country>( map.values());
	}

}
