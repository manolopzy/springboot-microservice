package com.worldexplorer.customerservice.entity;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "customers")
public class Customer{

	/**
	 * If there is a {@link @Id} annotation on a field, then 
	 * mongodb will use it as the document's identifier.
	 * In the case of no {@link @Id} annotation, if there is 
	 * a field called "id", then the mongodb will use it 
	 * as identifier.
	 * Otherwise, mongodb will create an identifier for us.
	 */
    private long id;

    @NotEmpty(message = "El número de documento no puede ser vacío")
    @Size( min = 8 , max = 8, message = "El tamaño del número de documento es 8")
    private String numberID;

    @NotEmpty(message = "El nombre no puede ser vacío")
    private String firstname;

    @NotEmpty(message = "El apellido no puede ser vacío")
    private String lastname;

    @NotEmpty(message = "el correo no puede estar vacío")
    @Email(message = "no es un dirección de correo bien formada")
    private String email;

    private String photoUrl;
    
    @NotNull(message = "la región no puede ser vacia")
    //@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Region region;

    //Definir el estado del cliente, creado/eliminado/...
    private String state;
    
    private int level;
    
    private int age;
    
    private List<Pet> pets;
}
