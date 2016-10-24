package com.tut.zycus;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.tut.zycus.client.AddressType;
import com.tut.zycus.client.Order;
import com.tut.zycus.client.Person;
import com.tut.zycus.domain.AddressDTO;
import com.tut.zycus.domain.OrderDTO;
import com.tut.zycus.domain.PersonDTO;
import com.tut.zycus.util.Mapper;
import com.tut.zycus.web.Controller;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PersonServiceApplication.class)
@WebIntegrationTest
@IntegrationTest("server.port:0")
public class TestAPIs {	

	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setUp() throws Exception {
		RestAssured.port = serverPort;
	}

	@Test
	public void testGetNavigationLinks() {


		given().	   	
		when().
			get("/persons").
		then().
			log().all().
			statusCode(200);



	}
	
	@Test
	public void TestCreatePerson() {
		
		PersonDTO person = createPerson();


		given().
			body(person).
			contentType(Controller.MEDIA_TYPE_PERSON_JSON_VALUE).			
		when().
			post("/persons/person").
		then().
			log().all().
			statusCode(200);
	}
	
	
	@Test
	public void TestCreateandGetPerson() {
		
		PersonDTO person = createPerson();

		Response response = given().
			body(person).
			contentType(Controller.MEDIA_TYPE_PERSON_JSON_VALUE).			
		when().
			post("/persons/person").
		then().
			log().all().
			statusCode(201).extract().response();
		
		String id = response.path("id");
		
	given().			
	when().
		get("/persons/person/"+id).
	then().
		log().all().
		statusCode(200);
	}
	
	@Test
	public void TestCreateandGetPersonWithOrder() {
		
		PersonDTO person = createPerson();

		Response response = given().
			body(person).
			contentType(Controller.MEDIA_TYPE_PERSON_JSON_VALUE).			
		when().
			post("/persons/person").
		then().
			log().all().
			statusCode(201).extract().response();
		
		Person personView = response.as(Person.class);
		
		given().			
		when().
			get("/persons/person/"+personView.getId()).
		then().
			log().all().
			statusCode(200);
		
		Order order = createOrder();
		order.setPersonId(personView.getId());
		
		response = given().
				body(order).
				contentType(Controller.MEDIA_TYPE_ORDER_JSON_VALUE).			
			when().
				post("/persons/person/"+personView.getId()+"/order").
			then().
				log().all().
				statusCode(201).extract().response();
			
		
	}
	

	
	
	
	public PersonDTO createPerson(){
		AddressDTO address =new AddressDTO();
		address.setLine1("ABS");
		address.setLine2("XYZ");
		address.setLine3("MNO");
		address.setType(AddressType.Home.toString());
		
		PersonDTO personDto = new PersonDTO();
		personDto.setAge(33);
		personDto.setCountry("India");
		personDto.setName("Amit");
		personDto.setState("Maharashta");
		personDto.setPincode(411022);
		personDto.setAddress(address);
		
		return personDto;

	}
	
	public Order createOrder(){
		Order order =  new Order();
		order.setOrderItem("Order1");
		return order;
	}
	
	public String converToJson(PersonDTO personDto){
		ObjectMapper mapper = new ObjectMapper();
		String PersonJson = "";
		try {
			PersonJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(PersonJson);
		return PersonJson;
		
		
	}
	

}
