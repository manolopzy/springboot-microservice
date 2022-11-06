package com.worldexplorer.customerservice.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;
/**
 * 
 * @author tanku
 *
 */
@QueryEntity
@Data
@Document("testcountries")
public class Country {
	
	private String name;

	private int population;
	
	private List<City> cities;
	
	
	@Override
	public String toString() {

		return "country : " + "name = " + name + ";" + "population = " + population + ";" + "cities = " + cities.toString() + ";";
	}
}
