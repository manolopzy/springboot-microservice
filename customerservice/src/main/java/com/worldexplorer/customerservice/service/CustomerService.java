package com.worldexplorer.customerservice.service;

import java.util.List;

import com.worldexplorer.customerservice.entity.Customer;
import com.worldexplorer.customerservice.entity.Region;

public interface CustomerService {

	public List<Customer> findCustomerAll();

	/**
	 * in our case, {@link Region} class contains id and name fields, 
	 * this query will return documents whose region matches exactly all fields 
	 * with the region that we pass by
	 * @param region
	 * @return
	 */
	public List<Customer> findCustomersByRegion(Region region);

	public List<Customer> findCustomersByRegionName(String regionName);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public Customer getCustomer(long id);

}
