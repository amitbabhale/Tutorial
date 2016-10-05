package com.app.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.client.Note;
import com.app.util.Mapper;

@Service
public class NoteService{

	@Autowired
	private NoteRepository repository;
	
	public Note save(NoteDTO note) {
		NoteDTO rnote = repository.save(note);		
		return Mapper.apply(rnote);
	}
	
	public Note get(String id) {
		Long longId = Long.parseLong(id);
		NoteDTO rnote = repository.findOne(longId);
		return Mapper.apply(rnote);
	}	
	
	public void delete(String id) {
		Long longId = Long.parseLong(id);
		repository.delete(longId);
	}

}
