package com.worldexplorer.shoppingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * {@link @EnableFeignClients} enables scans for interfaces that declare they are feign clients
 * @author tanku
 *
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ShoppingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingserviceApplication.class, args);
	}
}
