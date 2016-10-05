package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.client.Note;
import com.app.domain.NoteDTO;
import com.app.domain.NoteService;

@RestController
public class NoteController {
	
	public static final String MEDIA_TYPE_BASE_VALUE = "application/vnd.app.note";
    public static final String MEDIA_TYPE_JSON_VALUE = MEDIA_TYPE_BASE_VALUE + "+json";
	
    @Autowired
    NoteService service;
    
	@RequestMapping(value="/note",
			consumes={	MEDIA_TYPE_JSON_VALUE},
			produces={	MEDIA_TYPE_JSON_VALUE},
			method=RequestMethod.POST)
	public ResponseEntity<Note> publishNote(@RequestBody NoteDTO note) {
		Note rep = service.save(note);
		ResponseEntity<Note> entity =   new ResponseEntity<Note>(rep,null, HttpStatus.CREATED);	;
		return entity;		
	    
	}
	
	@RequestMapping(value="/note/{noteid}",			
			produces={	MEDIA_TYPE_JSON_VALUE},
			method=RequestMethod.GET)
	public ResponseEntity<Note> findNote(@PathVariable String noteid) throws NotFoundException {
		Note note = service.get(noteid); 
		if(note==null){
			throw new NotFoundException();
		}
			
		ResponseEntity<Note> entity =   new ResponseEntity<Note>(note,null, HttpStatus.OK);	;
		return entity;		
	    
	}

	@RequestMapping(value="/note/{noteid}",			
			produces={	MEDIA_TYPE_JSON_VALUE},
			method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteNote(@PathVariable String noteid) throws NotFoundException {
		Note note = service.get(noteid); 
		if(note==null){
			throw new NotFoundException();
		}
		service.delete(noteid);
		ResponseEntity<Note> entity =   new ResponseEntity<Note>(null,null, HttpStatus.NO_CONTENT);	;
		return entity;		
	    
	}
	
	@RequestMapping(value="/note/{noteid}",			
			produces={	MEDIA_TYPE_JSON_VALUE},
			method=RequestMethod.PUT)
	public ResponseEntity<Note> updateNote(@PathVariable String noteid,@RequestBody NoteDTO note) throws NotFoundException {
		Note nottr = service.get(noteid);
		if(nottr==null){
			throw new NotFoundException();
		}
		note.setId(Long.parseLong(nottr.getId()));
		Note rep = service.save(note);
		ResponseEntity<Note> entity =   new ResponseEntity<Note>(rep,null, HttpStatus.OK);	;
		return entity;		
	    
	}
}
 