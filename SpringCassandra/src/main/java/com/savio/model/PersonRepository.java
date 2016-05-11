package com.savio.model;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	Person findBypId(Integer id);
}
