package com.worldexplorer.customerservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.worldexplorer.customerservice.entity.Customer;
import com.worldexplorer.customerservice.entity.Pet;
import com.worldexplorer.customerservice.entity.Region;
import com.worldexplorer.customerservice.repository.CustomerRepository;
/**
 * @BeforeEach and @BeforeAll are the JUnit 5 equivalents of 
 * @Before and @BeforeClass.
 * @author tanku
 *
 */
@SpringBootTest
public class CustomerRepositoryTests {
	@Autowired
	private CustomerRepository customerRepository;
	private Random random = new Random();
	private List<Long> idsList = new ArrayList<>();
	private int numberOfCustomers = 10;
	@BeforeEach
	public void setup() {
		init();
	}
	AtomicLong customerIdGenerator = new AtomicLong(1000);
	AtomicInteger customerCounter = new AtomicInteger();
	private void init(){
		customerRepository.deleteAll();
		for (int i = 0; i < numberOfCustomers; i++) {
			createCustomer();
		}
    }
	
	private Customer createCustomer() {
		int counter = customerCounter.incrementAndGet();
		List<Pet> pets = getPets();
        //instances of services are already injected by this time.
		Customer customer = Customer.builder()
			.id(customerIdGenerator.getAndIncrement())
			.firstname("manu" + counter)
			.lastname("manolo" + counter)
			.email("manu" + counter + "@gmail.com")
			.numberID("" + random.nextInt(10000000, 99999999))
			.level(random.nextInt(0, 1000))
			.age(random.nextInt(0, 100))
			.pets(pets)
			.region(Region.builder().id(random.nextLong()).name("us").build())
			.photoUrl("http://abc/de")
			.state("created")
			.build();
		idsList.add(customer.getId());
		customerRepository.save(customer);
		return customer;
	}

	private List<Pet> getPets() {
		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet("dog", "Manuel" + random.nextInt(), new Date()));
		pets.add(new Pet("dog", "Manuel" + random.nextInt(), new Date()));
		pets.add(new Pet("dog", "Manuel" + random.nextInt(), new Date()));
		return pets;
	}

	@Test
	public void findAll() {
		List<Customer> customers = customerRepository.findAll();
		Assertions.assertThat(customers.size()).isEqualTo(numberOfCustomers);
	}
	
	@Test
	public void findById() {
		//System.out.println(idsList.size());
		long id = idsList.get(new Random().nextInt(0, idsList.size()));
		Optional<Customer> customer = customerRepository.findById(id);
		Assertions.assertThat(customer.get()).isNotNull();
	}
	
	@Test
	public void findByFirstname() {
		List<Customer> customers = customerRepository.findByFirstname("manu1");
		Assertions.assertThat(customers.size()).isEqualTo(1);
	}
	
	@Test
	public void findByFirstnameStartingWith() {
		List<Customer> customers = customerRepository.findByFirstnameStartingWith("manu");
		Assertions.assertThat(customers.size()).isEqualTo(numberOfCustomers);
	}
}
