package com.assignment.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "topLevelDomain", "alpha2Code", "alpha3Code", "callingCodes", "capital", "altSpellings",
		"region", "subregion", "population", "latlng", "demonym", "area", "gini", "timezones", "borders", "nativeName",
		"numericCode", "currencies", "languages", "translations", "relevance" })
public class Country {

	@JsonProperty("name")
	private String name;
	@JsonProperty("topLevelDomain")
	private List<String> topLevelDomain = null;
	@JsonProperty("alpha2Code")
	private String alpha2Code;
	@JsonProperty("alpha3Code")
	private String alpha3Code;
	@JsonProperty("callingCodes")
	private List<String> callingCodes = null;
	@JsonProperty("capital")
	private String capital;
	@JsonProperty("altSpellings")
	private List<String> altSpellings = null;
	@JsonProperty("region")
	private String region;
	@JsonProperty("subregion")
	private String subregion;
	@JsonProperty("population")
	private Integer population;
	@JsonProperty("latlng")
	private List<Double> latlng = null;
	@JsonProperty("demonym")
	private String demonym;
	@JsonProperty("area")
	private Double area;
	@JsonProperty("gini")
	private Double gini;
	@JsonProperty("timezones")
	private List<String> timezones = null;
	@JsonProperty("borders")
	private List<String> borders = null;
	@JsonProperty("nativeName")
	private String nativeName;
	@JsonProperty("numericCode")
	private Double numericCode;
	@JsonProperty("currencies")
	private List<String> currencies = null;
	@JsonProperty("languages")
	private List<String> languages = null;
	@JsonProperty("translations")
	private Translations translations;
	@JsonProperty("relevance")
	private Double relevance;

	public Country(String name, List<String> topLevelDomain, String alpha2Code, String alpha3Code,
			List<String> callingCodes, String capital, List<String> altSpellings, String region, String subregion,
			Integer population, List<Double> latlng, String demonym, Double area, Double gini, List<String> timezones,
			List<String> borders, String nativeName, Double numericCode, List<String> currencies,
			List<String> languages, Translations translations, Double relevance) {
		this.name = name;
		this.topLevelDomain = topLevelDomain;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
		this.callingCodes = callingCodes;
		this.capital = capital;
		this.altSpellings = altSpellings;
		this.region = region;
		this.subregion = subregion;
		this.population = population;
		this.latlng = latlng;
		this.demonym = demonym;
		this.area = area;
		this.gini = gini;
		this.timezones = timezones;
		this.borders = borders;
		this.nativeName = nativeName;
		this.numericCode = numericCode;
		this.currencies = currencies;
		this.languages = languages;
		this.translations = translations;
		this.relevance = relevance;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("topLevelDomain")
	public List<String> getTopLevelDomain() {
		return topLevelDomain;
	}

	@JsonProperty("topLevelDomain")
	public void setTopLevelDomain(List<String> topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("alpha2Code")
	public String getAlpha2Code() {
		return alpha2Code;
	}

	@JsonProperty("alpha2Code")
	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	@JsonProperty("alpha3Code")
	public String getAlpha3Code() {
		return alpha3Code;
	}

	@JsonProperty("alpha3Code")
	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	@JsonProperty("callingCodes")
	public List<String> getCallingCodes() {
		return callingCodes;
	}

	
	@JsonProperty("callingCodes")
	public void setCallingCodes(List<String> callingCodes) {
		this.callingCodes = callingCodes;
	}

	@JsonProperty("capital")
	public String getCapital() {
		return capital;
	}

	@JsonProperty("capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}

	@JsonProperty("altSpellings")
	public List<String> getAltSpellings() {
		return altSpellings;
	}

	@JsonProperty("altSpellings")
	public void setAltSpellings(List<String> altSpellings) {
		this.altSpellings = altSpellings;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("subregion")
	public String getSubregion() {
		return subregion;
	}

	@JsonProperty("subregion")
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	@JsonProperty("population")
	public Integer getPopulation() {
		if (population == null)
			population = 0;
		return population;
	}

	@JsonProperty("population")
	public void setPopulation(Integer population) {
		this.population = population;
	}

	@JsonProperty("latlng")
	public List<Double> getLatlng() {
		if (latlng==null) {
			latlng=new ArrayList<Double>();
		}
		return latlng;
	}

	@JsonProperty("latlng")
	public void setLatlng(List<Double> latlng) {
		this.latlng = latlng;
	}

	@JsonProperty("demonym")
	public String getDemonym() {
		return demonym;
	}

	@JsonProperty("demonym")
	public void setDemonym(String demonym) {
		this.demonym = demonym;
	}

	@JsonProperty("area")
	public Double getArea() {
		if (area == null) {
			area = 0d;
		}
		return area;
	}

	@JsonProperty("area")
	public void setArea(Double area) {
		this.area = area;
	}

	@JsonProperty("gini")
	public Double getGini() {
		if (gini == null) {
			gini = 0d;
		}
		return gini;
	}

	@JsonProperty("gini")
	public void setGini(Double gini) {
		this.gini = gini;
	}

	@JsonProperty("timezones")
	public List<String> getTimezones() {
		return timezones;
	}

	@JsonProperty("timezones")
	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}

	@JsonProperty("borders")
	public List<String> getBorders() {
		return borders;
	}

	@JsonProperty("borders")
	public void setBorders(List<String> borders) {
		this.borders = borders;
	}

	@JsonProperty("nativeName")
	public String getNativeName() {
		return nativeName;
	}

	@JsonProperty("nativeName")
	public void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	@JsonProperty("numericCode")
	public Double getNumericCode() {
		if (numericCode == null)
			numericCode = 0d;
		return numericCode;
	}

	@JsonProperty("numericCode")
	public void setNumericCode(Double numericCode) {
		this.numericCode = numericCode;
	}

	@JsonProperty("currencies")
	public List<String> getCurrencies() {
		return currencies;
	}

	@JsonProperty("currencies")
	public void setCurrencies(List<String> currencies) {
		this.currencies = currencies;
	}

	@JsonProperty("languages")
	public List<String> getLanguages() {
		return languages;
	}

	@JsonProperty("languages")
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	@JsonProperty("translations")
	public Translations getTranslations() {
		return translations;
	}

	@JsonProperty("translations")
	public void setTranslations(Translations translations) {
		this.translations = translations;
	}

	@JsonProperty("relevance")
	public Double getRelevance() {
		if (relevance == null)
			relevance = 0d;
		return relevance;
	}

	@JsonProperty("relevance")
	public void setRelevance(Double relevance) {
		this.relevance = relevance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n----- Country Information-----\n");
		sb.append("Name: " + getName() + "\n");
		sb.append("TopLevelDomain: " + getTopLevelDomain() + "\n");
		sb.append("alpha2Code: " + getAlpha2Code() + "\n");
		sb.append("alpha3Code: " + getAlpha3Code() + "\n");
		sb.append("callingCodes: " + getCallingCodes() + "\n");
		sb.append("capital: " + getCapital() + "\n");
		sb.append("altSpellings:" + getAltSpellings() + "\n");
		sb.append("region: " + getRegion() + "\n");
		sb.append("subregion: " + getSubregion() + "\n");
		sb.append("population: " + getPopulation() + "\n");
		sb.append("latlng: " + getLatlng() + "\n");
		sb.append("demonym:" + getDemonym() + "\n");
		sb.append("area: " + getArea() + "\n");
		sb.append("gini: " + getGini() + "\n");
		sb.append("timezones: " + getTimezones() + "\n");
		sb.append("borders:" + getBorders() + "\n");
		sb.append("nativeName: " + getNativeName() + "\n");
		sb.append("numericCode: " + getNumericCode() + "\n");
		sb.append("currencies: " + getCurrencies() + "\n");
		sb.append("languages: " + getLanguages() + "\n");
		sb.append("translations:" + getTranslations() + "\n");
		sb.append("relevance:" + getRelevance() + "\n");
		sb.append("*****************************");
		return sb.toString();
	}

}