package com.worldexplorer.customerservice.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.worldexplorer.customerservice.entity.Equip;

@Repository
public class EquipRepository implements CommonRepository<Equip> {

	@Autowired
	private MongoTemplate repositoryTemplate;

	@Override
	public Equip save(Equip entity) {
		return repositoryTemplate.save(entity);
	}

	@Override
	public Iterable<Equip> save(Collection<Equip> entities) {
		return repositoryTemplate.insertAll(entities);
	}

	@Override
	public void delete(Equip entity) {
		repositoryTemplate.remove(entity);
	}

	@Override
	public Equip findById(String id) {
		return repositoryTemplate.findById(id, Equip.class);
	}

	@Override
	public Iterable<Equip> findAll() {
		return repositoryTemplate.findAll(Equip.class);
	}

	public Iterable<Equip> findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return repositoryTemplate.find(query, Equip.class);
	}

	public Iterable<Equip> findByLevelGreaterThan(int level) {

		Query query = new Query();
		query.addCriteria(Criteria.where("level").gt(level));
		return repositoryTemplate.find(query, Equip.class);
	}

	public Iterable<Equip> findByNameStartingWith(String regexp) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^" + regexp));
		return repositoryTemplate.find(query, Equip.class);
	}

	public Iterable<Equip> findByNameEndingWith(String regexp) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(regexp + "$"));
		return repositoryTemplate.find(query, Equip.class);
	}

	public Iterable<Equip> findByLevelBetween(int minLevel, int maxLevel) {
		Query query = new Query();
		query.addCriteria(Criteria.where("level").gt(minLevel).lt(maxLevel));
		return repositoryTemplate.find(query, Equip.class);
	}
	
	public Iterable<Equip> findAllByOrder() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "level"));
		return repositoryTemplate.find(query, Equip.class);
	}
	/**
	 * 
	 * @param pageIndex zero based page index, must not be negative
	 * @param pageSize the number of documents each page
	 * @return
	 */
	public Iterable<Equip> findByPage(int pageIndex, int pageSize) {
		//page zero-based page index, must not be negative.
		final Pageable pageableRequest = PageRequest.of(pageIndex, pageSize);
		Query query = new Query();
		query.with(pageableRequest);
		return repositoryTemplate.find(query, Equip.class);
	}
}
