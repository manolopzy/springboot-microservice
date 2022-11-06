package com.worldexplorer.customerservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldexplorer.customerservice.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceApplicationTests {

	@Autowired
	CustomerRepository repository;
	@Test
	public void contextLoads() {
		
	}
	
	
}
