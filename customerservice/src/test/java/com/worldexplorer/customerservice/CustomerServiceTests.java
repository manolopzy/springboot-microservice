package com.worldexplorer.customerservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.worldexplorer.customerservice.entity.Customer;
import com.worldexplorer.customerservice.entity.Region;
import com.worldexplorer.customerservice.repository.CustomerRepository;
import com.worldexplorer.customerservice.service.CustomerService;
@SpringBootTest
public class CustomerServiceTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	private List<Long> idsList = new ArrayList<>();
	private List<Region> regions = new ArrayList<>();
	private int size = 0;
	@BeforeEach
	public void setup() {
		List<Customer> customers = customerRepository.findAll();
		size = customers.size();
		System.out.println("real size = " + size);
		for (Customer customer : customers) {
			idsList.add(customer.getId());
			regions.add(customer.getRegion());
		}
	}
	
	
	@Test
	public void findByRegion() {
		Region region = regions.get(new Random().nextInt(0, regions.size()));
		List<Customer> customers = customerService.findCustomersByRegion(region);
		System.out.println("find by region return customers = " + customers.size());
		Assertions.assertThat(customers.size()).isEqualTo(1);
	}
	
	@Test
	public void findByRegionName() {
		Region region = regions.get(new Random().nextInt(0, regions.size()));
		List<Customer> customers = customerService.findCustomersByRegionName(region.getName());
		System.out.println("find by region name return customers = " + customers.size());
		Assertions.assertThat(customers.size()).isEqualTo(size);
	}
	
}
