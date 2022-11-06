package com.worldexplorer.customerservice.entity;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pet {

	private String type;
	
	private String name;
	
	private Date birthday;
	
	
}
