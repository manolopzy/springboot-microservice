package com.worldexplorer.customerservice.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;
@QueryEntity
@Data
@Document("testcities")
public class City {
	
	private String name = "Alicante";
	
	private String description = 
			"Alicante is a port city on Spain’s southeastern Costa Blanca, and the capital of the Alicante province. Its old town, Barrio de la Santa Cruz, has narrow streets, colored houses and a nightlife scene. From here, an elevator or a steep climb leads to medieval Castillo de Santa Bárbara, set on a hilltop with sweeping views of the Mediterranean coast.";
	
	private Location location;
	
	private Address address;
	
	private String country;
	//height above sea level
	private int altitude;
}
