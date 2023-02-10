package com.springcrud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "population")
public class UsaPopulation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonProperty("ID Nation")
	@Column(name = "id_nation")
	private String idNation;
	
	@JsonProperty("Nation")
	@Column(name = "nation")
	private String nation ;
	
	@JsonProperty("ID Year")
	@Column(name = "id_year")
	private int idYear ;
	
	@JsonProperty("Year")
	@Column(name = "year")
	private int year ;
	
	@JsonProperty("Population")
	@Column(name="population")
	private int population ;
	
	@JsonProperty("Slug Nation")
	@Column(name ="slug_nation")
	private String slugNation; 
	
	public UsaPopulation(String idNation, String nation, int idYear, int year, int population, String slugNation) {
		super();
		this.idNation = idNation;
		this.nation = nation;
		this.idYear = idYear;
		this.year = year;
		this.population = population;
		this.slugNation = slugNation;
	}

	public String getIdNation() {
		return idNation;
	}

	public void setIdNation(String idNation) {
		this.idNation = idNation;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public int getIdYear() {
		return idYear;
	}

	public void setIdYear(int idYear) {
		this.idYear = idYear;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getSlugNation() {
		return slugNation;
	}

	public void setSlugNation(String slugNation) {
		this.slugNation = slugNation;
	}

}
