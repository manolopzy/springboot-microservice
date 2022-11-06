package com.worldexplorer.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldexplorer.customerservice.entity.Customer;
import com.worldexplorer.customerservice.entity.Region;
import com.worldexplorer.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findCustomerAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findCustomersByRegion(Region region) {
		return customerRepository.findByRegion(region);
	}

	/**
	 * idempotent implementation of post request using a 
	 * unique number id to identify a customer, so no matter 
	 * how many time with the same creation parameters, 
	 * the state of the database will remain the same
	 */
	@Override
	public Customer createCustomer(Customer customer) {

		Customer customerDB = customerRepository.findByNumberID(customer.getNumberID());
		if (customerDB != null) {
			return customerDB;
		}

		customer.setState("created");
		customerDB = customerRepository.save(customer);
		return customerDB;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customerDB = getCustomer(customer.getId());
		if (customerDB == null) {
			return null;
		}
		customerDB.setFirstname(customer.getFirstname());
		customerDB.setLastname(customer.getLastname());
		customerDB.setEmail(customer.getEmail());
		customerDB.setPhotoUrl(customer.getPhotoUrl());

		return customerRepository.save(customerDB);
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		Customer customerDB = getCustomer(customer.getId());
		if (customerDB == null) {
			return null;
		}
		customer.setState("DELETED");
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(long id) {
		return customerRepository.findById(id).orElse(null);
	}

	@Override
	public List<Customer> findCustomersByRegionName(String regionName) {
		return customerRepository.findByRegionName(regionName);
	}
}
