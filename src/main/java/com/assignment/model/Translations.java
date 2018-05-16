package com.assignment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "de", "es", "fr", "ja", "it" })
public class Translations {

	@JsonProperty("de")
	private String de;
	@JsonProperty("es")
	private String es;
	@JsonProperty("fr")
	private String fr;
	@JsonProperty("ja")
	private String ja;
	@JsonProperty("it")
	private String it;

	@JsonProperty("de")
	public String getDe() {
		if(de==null)
			de="";
		return de;
	}

	@JsonProperty("de")
	public void setDe(String de) {
		this.de = de;
	}

	@JsonProperty("es")
	public String getEs() {
		if(es==null)
		es="";
		return es;
	}

	@JsonProperty("es")
	public void setEs(String es) {
		this.es = es;
	}

	@JsonProperty("fr")
	public String getFr() {
		if(fr==null)
			fr="";
		return fr;
	}

	@JsonProperty("fr")
	public void setFr(String fr) {
		this.fr = fr;
	}

	@JsonProperty("ja")
	public String getJa() {
		if(ja==null)
			ja="";
		return ja;
	}

	@JsonProperty("ja")
	public void setJa(String ja) {
		this.ja = ja;
	}

	@JsonProperty("it")
	public String getIt() {
		if(it==null)
			it="";
		return it;
	}

	@JsonProperty("it")
	public void setIt(String it) {
		this.it = it;
	}

}
