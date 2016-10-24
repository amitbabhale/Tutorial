package com.tut.zycus.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	List<Link> links = new ArrayList<Link>();
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public  ResponseEntity<List<Link>> getNavigationLinks() {
		
		Link linkSelf = new Link("/person", "self");
		Link linkPerson = new Link("/persons/person", "createPerson");
		links.add(linkSelf);
		links.add(linkPerson);
		
		
        return new ResponseEntity<List<Link>>(links, HttpStatus.OK);
	}
}
