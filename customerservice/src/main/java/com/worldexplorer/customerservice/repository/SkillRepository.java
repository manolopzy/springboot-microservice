package com.worldexplorer.customerservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.worldexplorer.customerservice.entity.Skill;
/**
 * Generated Query Methods
 * auto-generated queries out of method names
 * 
 * and JSON Query Methods If we can't represent a query 
 * with the help of a method name or criteria
 * 
 * @author tanku
 *
 */
public interface SkillRepository extends MongoRepository<Skill, String>{

	/**
	 * find...By...
	 * The placeholder ?0 references the first parameter of the method.
	 * @param name
	 * @return
	 */
	@Query("{ 'name' : ?0 }")
	List<Skill> findSkillsByName(String name);
	
	/**
	 * findSkillsByRegexpName("^abc"); starting with
	 * findSkillsByRegexpName("abc$"); ending with
	 * @param regexp
	 * @return
	 */
	@Query("{ 'name' : { $regex: ?0 } }")
	List<Skill> findSkillsByRegexpName(String regexp);
	
	@Query("{ 'level' : { $gt: ?0, $lt: ?1 } }")
	List<Skill> findSkillsByLevelBetween(int levelGT, int levelLT);
}
