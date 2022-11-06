package com.worldexplorer.customerservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * There are two ways to manage the collection name, the first 
 * is to use {@link @Document} annotation to specify the name 
 * you want, the other is the default one, the mongo template 
 * will use the class name changed to start with a lower-case 
 * letter.
 * @author tanku
 *
 */
@Data
@Document(collection = "testequips")
public class Equip{

	private int id;
	
	private int equipId;
	
	private String name;
	
	private int level;
	
	
}
