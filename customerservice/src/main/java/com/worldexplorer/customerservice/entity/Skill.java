package com.worldexplorer.customerservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * mongo database will create the id for us
 * @author tanku
 *
 */
@Data
@Document(collection = "testskills")
public class Skill {
	
	private int skillId;
	
	private int playerId;
	
	private int level;
	
	
    
}
