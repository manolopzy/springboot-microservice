package com.worldexplorer.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.worldexplorer.customerservice.entity.City;
import com.worldexplorer.customerservice.entity.QCity;
import com.worldexplorer.customerservice.repository.CityRepository;
@Service
public class CityServiceImpl implements CityService{

	private static final String ENTITY_NAME = "city";
	
	@Autowired
	private CityRepository repository;

	@Override
	public List<City> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City findByName(String name) {
		QCity qCity = new QCity(ENTITY_NAME);
		Predicate predicate = qCity.name.eq(name);
		Optional<City> result = repository.findOne(predicate);
		return result.get();
	}

	@Override
	public Iterable<City> findByNameStartingWith(String regexp) {
		QCity qCity = new QCity(ENTITY_NAME);
		Predicate predicate = qCity.name.startsWith(regexp);
		Iterable<City> result = repository.findAll(predicate);
		return result;
	}

	@Override
	public Iterable<City> findByNameEndingWith(String regexp) {
		QCity qCity = new QCity(ENTITY_NAME);
		Predicate predicate = qCity.name.endsWith(regexp);
		Iterable<City> result = repository.findAll(predicate);
		return result;
	}

	@Override
	public Iterable<City> findByCountry(String name) {
		
		return null;
	}

	@Override
	public Iterable<City> findByCityAltitudBetween(int altitudBT, int altitudLT) {
		QCity qCity = new QCity(ENTITY_NAME);
		Predicate predicate = qCity.altitude.between(altitudBT, altitudLT);
		Iterable<City> result = repository.findAll(predicate);
		return result;
	}

	@Override
	public City findByZipcode(String name) {
		QCity qCity = new QCity(ENTITY_NAME);
		Predicate predicate = qCity.address.zipCode.eq(name);
		Optional<City> result = repository.findOne(predicate);
		return result.get();
	}
	
	

}
