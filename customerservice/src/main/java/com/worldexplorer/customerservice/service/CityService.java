package com.worldexplorer.customerservice.service;

import java.util.List;

import com.worldexplorer.customerservice.entity.City;

public interface CityService {

	public List<City> findAll();
	
	public City findByName(String name);

	public Iterable<City> findByNameStartingWith(String regexp);
	
	public Iterable<City> findByNameEndingWith(String regexp);
	
	public Iterable<City> findByCountry(String name);
	
	public City findByZipcode(String name);
	
	public Iterable<City> findByCityAltitudBetween(int altitudBT, int altitudLT);
}
