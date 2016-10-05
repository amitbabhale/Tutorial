package com.app.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<NoteDTO, Long> {

	List<NoteDTO> findAll();
}
