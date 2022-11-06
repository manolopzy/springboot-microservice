package com.worldexplorer.customerservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.worldexplorer.customerservice.entity.Customer;
import com.worldexplorer.customerservice.entity.Region;
/**
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
 * @author tanku
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, Long>, QuerydslPredicateExecutor<Customer>{
	
	public Customer findByNumberID(String numberID);

	public List<Customer> findByLastname(String lastname);

	public List<Customer> findByRegion(Region region);

	public List<Customer> findByRegionName(String regionName);
	public List<Customer> findByFirstname(String name);
	public List<Customer> findByFirstnameStartingWith(String regexp);
	
	public List<Customer> findByFirstnameEndingWith(String regexp);
	
	public List<Customer> findByLevelBetween(int minLevel, int maxLevel);
	/**
	 * find all customers that have names containing a specified string as 
	 * part of their name, then order the results by age, in ascending order
	 * 
	 * @param name finding all customers that have names containing this name pattern
	 * @return
	 */
	public List<Customer> findByFirstnameLikeOrderByAgeAsc(String name);
	
	
	
}
