package com.worldexplorer.customerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.worldexplorer.customerservice.entity.City;
/**
 * 
 * 1 Generated Query Methods
 * auto-generated queries out of method names
 * 
 * 2 and JSON Query Methods which are low level 
 * queries If we can't represent a query 
 * with the help of a method name or criteria
 * 
 * 3 QueryDSL Queries : Unified Queries for Java
 * With this support, we can create queries using 
 * the fields of a class, without coupling with the 
 * specific database query language
 * https://www.baeldung.com/queries-in-spring-data-mongodb
 * @author tanku
 *
 */
public interface CityRepository extends MongoRepository<City, String>, QuerydslPredicateExecutor<City> {
}
