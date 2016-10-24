package com.tut.zycus.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tut.zycus.client.AddressType;

public class ConvertTOJson {

	public static void main(String[] args) {
		AddressDTO address =new AddressDTO();
		address.setLine1("ABS");
		address.setLine2("XYZ");
		address.setLine3("MNO");
		address.setType(AddressType.Home.toString());
		
		PersonDTO personDto = new PersonDTO();
		personDto.setAge(33);
		personDto.setCountry("India");
		personDto.setName("Amit");
		personDto.setName("Maharashta");
		personDto.setPincode(411022);
		personDto.setAddress(address);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String PersonJson = "";
		try {
			PersonJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(PersonJson);

	}

}
