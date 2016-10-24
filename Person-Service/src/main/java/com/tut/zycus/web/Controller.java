/**
 * 
 */
package com.tut.zycus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tut.zycus.client.Order;
import com.tut.zycus.client.Person;
import com.tut.zycus.domain.PersonDTO;
import com.tut.zycus.domain.PersonService;

/**
 * @author amit
 * Exception Handling remaining
 * Generating hateoas links for resources
 */
@RestController
public class Controller {

	public static final String MEDIA_TYPE_PERSON_BASE_VALUE = "application/vnd.app.person";
	public static final String MEDIA_TYPE_ORDER_BASE_VALUE = "application/vnd.app.person.order";
	
	public static final String MEDIA_TYPE_PERSON_JSON_VALUE = MEDIA_TYPE_PERSON_BASE_VALUE + "+json";
	public static final String MEDIA_TYPE_ORDER_JSON_VALUE = MEDIA_TYPE_ORDER_BASE_VALUE + "+json";

	@Autowired
	PersonService service;

	@RequestMapping(value="/persons/person",
			consumes={	MEDIA_TYPE_PERSON_JSON_VALUE},
			produces={	MEDIA_TYPE_PERSON_JSON_VALUE},
			method=RequestMethod.POST)
	public ResponseEntity<Person> createPerson(@RequestBody PersonDTO person) {
		Person rep = service.save(person);
		ResponseEntity<Person> entity =   new ResponseEntity<Person>(rep,null, HttpStatus.CREATED);	;
		return entity;
	}
	
	
	@RequestMapping(value="/persons/person/{personid}",			
			produces={	MEDIA_TYPE_PERSON_JSON_VALUE},
			method=RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable(value="personid") final String personID) {
		Person rep = service.getPerson(personID);		
		ResponseEntity<Person> entity =   new ResponseEntity<Person>(rep,null, HttpStatus.OK);	;
		return entity;		

	}
	
	@RequestMapping(value="/persons/person/{personid}/order",			
			consumes={	MEDIA_TYPE_ORDER_JSON_VALUE},
			produces={	MEDIA_TYPE_ORDER_JSON_VALUE},			
			method=RequestMethod.POST)
	public ResponseEntity<Order> placeOrderForPerson(@PathVariable(value="personid") final String personID, @RequestBody Order order) {
		Order rep = service.saveOrder(personID, order);
		ResponseEntity<Order> entity =   new ResponseEntity<Order>(rep,null, HttpStatus.CREATED);	;
		return entity;
	}
	
	
	
}
