package com.example;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.NoteServiceApplication;
import com.app.domain.NoteDTO;
import com.app.domain.NoteRepository;
import com.app.web.NoteController;
import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NoteServiceApplication.class)
@WebIntegrationTest(value = {"security.ignored=/**"}, randomPort = true)
public class NoteServiceTest {

	@Value("${local.server.port}")
	int port; 

	@Autowired
	NoteRepository noterepository;

	@Before
	public void setUpController()
	{
		// start from scratch for each test        
		noterepository.deleteAll();
		RestAssured.port = port;
	}

	@Test    
	public void testPublishNoteWithNoData()
	{

		//Case 1 : When empty string is given as input to create comment
		given()	    		
			.contentType(NoteController.MEDIA_TYPE_JSON_VALUE)
			.body("")            
		.when()
			.post("/note")
		.then()
			.log().all()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test    
	public void testPublishNoteWithData()
	{

		NoteDTO dto = new NoteDTO();
		dto.setKey("amit");
		dto.setSubject("app-direct");
		dto.setText("demo");
		
		//Case 1 : When empty string is given as input to create comment
		given()	    		
			.contentType(NoteController.MEDIA_TYPE_JSON_VALUE)
			.body(dto)            
		.when()
			.post("/note")
		.then()
			.log().all()
			.statusCode(HttpStatus.CREATED.value());
	}

}
