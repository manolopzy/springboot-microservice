package com.worldexplorer.shoppingservice.msclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.worldexplorer.shoppingservice.model.Customer;
/**
 * Esta interfaz anotada con {@link @FeignClient} define las interfaces de recursos del 
 * microservicio de cliente, que son iguales que las interfaces 
 * de los controles en dicho microservicio, el marco openfeign 
 * es el encargador de communicar con el servicio, mandar peticion, 
 * deserializar los datos recibidos 
 * 
 * En la anotacion de {@link @FeignClient}, tenemos que decir al
 * marco open feign, que servicio que vamos a visitar, el nombre 
 * es el de la instancia del microservicio en el servidor de eureka
 * 
 * @author tanku
 *
 */
@FeignClient(name = "customerservice")
@RequestMapping("/customers")
public interface CustomerServiceClient {
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
