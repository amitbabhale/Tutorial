package com.tut.zycus.domain;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonDTO, String> {

}
