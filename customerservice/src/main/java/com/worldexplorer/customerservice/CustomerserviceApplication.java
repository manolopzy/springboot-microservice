package com.worldexplorer.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.worldexplorer.customerservice.entity.Customer;
@EnableEurekaClient
@SpringBootApplication
public class CustomerserviceApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(CustomerserviceApplication.class, args);
		MongoTemplate template =  context.getBean(MongoTemplate.class);
		System.out.print(template.getCollectionName(Customer.class));
	}

//	@Autowired
//	private CustomerRepository customerRepository;
//	
//	@PostConstruct
//    public void init(){
//		customerRepository.deleteAll();
//        //instances of services are already injected by this time.
//		Customer customer = Customer.builder()
//			.id(new Random().nextLong())
//			.firstName("manu")
//			.lastName("manolo")
//			.email("manu@gmail.com")
//			.numberID("12323123")
//			.region(Region.builder().id(new Random().nextLong()).name("us").build())
//			.photoUrl("http://abc/de")
//			.state("created")
//			.build();
//		customerRepository.save(customer);
//		
//		customer = Customer.builder()
//			.id(new Random().nextLong())
//			.firstName("manu2")
//			.lastName("manolo2")
//			.email("manu2@gmail.com")
//			.numberID("12324123")
//			.region(Region.builder().id(new Random().nextLong()).name("us").build())
//			.photoUrl("http://abc/de")
//			.state("created")
//			.build();
//		customerRepository.save(customer);
//    }
	
	
}
