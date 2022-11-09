package com.worldexplorer.shoppingservice.msclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.worldexplorer.shoppingservice.model.Product;

/**
 * Esta interfaz anotada con {@link @FeignClient} define las interfaces de recursos del 
 * microservicio de producto, que son iguales que las interfaces 
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
@FeignClient(name = "productservice")
//@RequestMapping("/products")
public interface ProductServiceClient {
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(required = true) long id);
	
	@GetMapping("/products/{id}/stock")
	public ResponseEntity<Product> updateStock(@PathVariable long id, @RequestParam(name = "quantity") double quantity);
}
