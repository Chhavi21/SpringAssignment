package com.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.assignment.model.Country;
import com.assignment.model.Translations;

public class CountryDao {
	@Autowired
	JdbcTemplate template;

	public List<Country> getAllCountries() {
		String sql = "SELECT c1.*, l1.languages,  c2.currencies, t1.timezones, c3.callingCodes, l2.latlng, t2.topLevelDomain,  a.altSpellings ,  b.borders,t3.* FROM Country as c1 INNER JOIN  languages as l1 on c1.name=l1.name  INNER JOIN   currencies as c2 on c1.name =c2.name INNER JOIN  timezones as t1 on c1.name = t1.name INNER JOIN  callingCodes as c3 on c1.name = c3.name INNER JOIN  latlng as l2 on c1.name = l2.name INNER JOIN  topLevelDomain as t2 on c1.name = t2.name INNER JOIN  altSpellings as a on c1.name = a.name INNER JOIN  borders as b on c1.name = b.name INNER JOIN  translations as t3 on c1.name = t3.name order by c1.name";

		List<Country> countries = (List<Country>) template.query(sql, new CountryExtractor());
		return countries;
	}

	public List<String> getCountryNames() {
		String sql = "SELECT name FROM Country";
		List<String> countryNames = template.queryForList(sql, String.class);
		return countryNames;

	}

	public void addCountry(Country country) {
		// System.out.println("template" +template);
		String sql = "INSERT INTO country(name,alpha2Code,alpha3Code,capital,region,subregion,population,"
				+ "demonym,area,gini,nativeName,numericCode,relevance)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		template.update(sql, country.getName(), country.getAlpha2Code(), country.getAlpha3Code(), country.getCapital(),
				country.getRegion(), country.getSubregion(), country.getPopulation(), country.getDemonym(),
				country.getArea(), country.getGini(), country.getNativeName(), country.getNumericCode(),
				country.getRelevance());
		for (String languages : country.getLanguages()) {
			String sql1 = "INSERT INTO languages(name,languages)" + "VALUES(?,?)";
			template.update(sql1, country.getName(), languages);
		}
		Translations translations = country.getTranslations();
		String sql1 = "INSERT INTO translations(name,de,es,fr,ja,it)" + "VALUES(?,?,?,?,?,?)";
		template.update(sql1, country.getName(), translations.getDe(), translations.getEs(), translations.getFr(),
				translations.getJa(), translations.getIt());

		for (String currencies : country.getCurrencies()) {
			String sql2 = "INSERT INTO currencies(name,currencies)" + "VALUES(?,?)";
			template.update(sql2, country.getName(), currencies);
		}
		for (String timezones : country.getTimezones()) {
			String sql3 = "INSERT INTO timezones(name,timezones)" + "VALUES(?,?)";
			template.update(sql3, country.getName(), timezones);
		}
		for (String callingCodes : country.getCallingCodes()) {
			String sql4 = "INSERT INTO callingCodes(name,callingCodes)" + "VALUES(?,?)";
			template.update(sql4, country.getName(), callingCodes);
		}
		for (Double latlng : country.getLatlng()) {
			String sql5 = "INSERT INTO latlng(name,latlng)" + "VALUES(?,?)";
			template.update(sql5, country.getName(), latlng);
		}
		for (String topLevelDomain : country.getTopLevelDomain()) {
			String sql6 = "INSERT INTO topLevelDomain(name,topLevelDomain)" + "VALUES(?,?)";
			template.update(sql6, country.getName(), topLevelDomain);
		}
		for (String altSpellings : country.getAltSpellings()) {
			String sql7 = "INSERT INTO altSpellings(name,altSpellings)" + "VALUES(?,?)";
			template.update(sql7, country.getName(), altSpellings);
		}
		for (String borders : country.getBorders()) {
			String sql8 = "INSERT INTO borders(name,borders)" + "VALUES(?,?)";
			template.update(sql8, country.getName(), borders);
		}
	}

	public Country select(String name) {
		String sql = "SELECT c1.*, l1.languages,  c2.currencies, t1.timezones, c3.callingCodes, l2.latlng, t2.topLevelDomain,  a.altSpellings ,  b.borders,t3.* FROM Country as c1 INNER JOIN  languages as l1 on c1.name=l1.name  INNER JOIN   currencies as c2 on c1.name =c2.name INNER JOIN  timezones as t1 on c1.name = t1.name INNER JOIN  callingCodes as c3 on c1.name = c3.name INNER JOIN  latlng as l2 on c1.name = l2.name INNER JOIN  topLevelDomain as t2 on c1.name = t2.name INNER JOIN  altSpellings as a on c1.name = a.name INNER JOIN  borders as b on c1.name = b.name INNER JOIN  translations as t3 on c1.name = t3.name WHERE c1.name='"
				+ name + "'";

		System.out.println("SQL ********" + sql);
		List<Country> list = (List<Country>) template.query(sql, new CountryExtractor());
		System.out.println("list ********" + list);
		return list.get(0);
	}

	public void update(Country country) {
		// update
		String sql = "UPDATE country SET  alpha2Code=?, alpha3Code=?, capital=?, region=?, subregion=?, population=?, demonym=?, area=?, gini=?, nativeName=?, numericCode=?, relevance=? WHERE name=?";
		template.update(sql, country.getAlpha2Code(), country.getAlpha3Code(), country.getCapital(),
				country.getRegion(), country.getSubregion(), country.getPopulation(), country.getDemonym(),
				country.getArea(), country.getGini(), country.getNativeName(), country.getNumericCode(),
				country.getRelevance(), 
				country.getName());

		String sql1 = "UPDATE translations SET  de=?, es=?, fr=?, it=?, ja=?  WHERE name=?";
		template.update(sql1, country.getTranslations().getDe(), country.getTranslations().getEs(),
				country.getTranslations().getFr(), country.getTranslations().getIt(), country.getTranslations().getJa(),
				country.getName());

		for (String languages : country.getLanguages()) {
			String sql2 = "UPDATE languages SET  languages=?  WHERE name=?";
			template.update(sql2, languages, country.getName());
		}
		for (String currencies : country.getCurrencies()) {
			String sql2 = "UPDATE currencies SET  currencies=?  WHERE name=?";
			template.update(sql2, currencies, country.getName());
		}
		for (String timezones : country.getTimezones()) {
			String sql2 = "UPDATE timezones SET  timezones=?  WHERE name=?";
			template.update(sql2, timezones, country.getName());
		}
		for (String callingCodes : country.getCallingCodes()) {
			String sql2 = "UPDATE callingCodes SET  callingCodes=?  WHERE name=?";
			template.update(sql2, callingCodes, country.getName());
		}
		for (Double latlng : country.getLatlng()) {
			String sql2 = "UPDATE latlng SET  latlng=?  WHERE name=?";
			template.update(sql2, latlng, country.getName());
		}
		for (String topLevelDomain : country.getTopLevelDomain()) {
			String sql2 = "UPDATE topLevelDomain SET  topLevelDomain=?  WHERE name=?";
			template.update(sql2, topLevelDomain, country.getName());
		}
		for (String altSpellings : country.getAltSpellings()) {
			String sql2 = "UPDATE altSpellings SET  altSpellings=?  WHERE name=?";
			template.update(sql2, altSpellings, country.getName());
		}
		for (String borders : country.getBorders()) {
			String sql2 = "UPDATE borders SET  borders=?  WHERE name=?";
			template.update(sql2, borders, country.getName());
		}

	}

	public void delete(String name) {
		String sql1 = "DELETE FROM translations WHERE name=?";
		template.update(sql1, name);
		String sql2 = "DELETE FROM languages WHERE name=?";
		template.update(sql2, name);
		String sql3 = "DELETE FROM currencies WHERE name=?";
		template.update(sql3, name);
		String sql4 = "DELETE FROM timezones WHERE name=?";
		template.update(sql4, name);
		String sql5 = "DELETE FROM callingCodes WHERE name=?";
		template.update(sql5, name);
		String sql6 = "DELETE FROM latlng WHERE name=?";
		template.update(sql6, name);
		String sql7 = "DELETE FROM topLevelDomain WHERE name=?";
		template.update(sql7, name);
		String sql8 = "DELETE FROM altSpellings WHERE name=?";
		template.update(sql8, name);
		String sql9 = "DELETE FROM borders WHERE name=?";
		template.update(sql9, name);
		System.out.println("delete othere");
		String sql = "DELETE FROM country WHERE name=?";
		template.update(sql, name);
		
	}

}
