/**
 * 
 */
package com.tut.zycus.util;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.tut.zycus.client.Address;
import com.tut.zycus.client.Order;
import com.tut.zycus.client.Person;
import com.tut.zycus.domain.AddressDTO;
import com.tut.zycus.domain.OrderDTO;
import com.tut.zycus.domain.PersonDTO;

/**
 * @author amit
 *
 */
public class Mapper {

	public static Person apply(PersonDTO personDto){
		Person person = new Person();
		person.setId(personDto.getPersonid());
		person.setAge(personDto.getAge());
		person.setCountry(personDto.getCountry());
		person.setName(personDto.getName());
		person.setPincode(personDto.getPincode());
		person.setAddress(addressToView(personDto.getAddress()));
		
		return person;
		
	}

	private static Address addressToView(AddressDTO addressDto) {
		Address address = new Address();
		address.setType(addressDto.getType());
		address.setLine1(addressDto.getLine1());
		address.setLine2(addressDto.getLine2());
		address.setLine3(addressDto.getLine3());
		return address;
	}
	
	public static PersonDTO apply(Person person){
		PersonDTO PersonDTO = new PersonDTO();
		PersonDTO.setPersonid(person.getId());
		PersonDTO.setAge(person.getAge());
		PersonDTO.setCountry(person.getCountry());
		PersonDTO.setName(person.getName());
		PersonDTO.setPincode(person.getPincode());
		PersonDTO.setAddress(addressToModel(person.getAddress()));
		
		return PersonDTO;
		
	}

	private static AddressDTO addressToModel(Address address) {
		AddressDTO  addressDto = new AddressDTO();
		addressDto.setType(address.getType());
		addressDto.setLine1(address.getLine1());
		addressDto.setLine2(address.getLine2());
		addressDto.setLine3(address.getLine3());
		return addressDto;
	}

	public static OrderDTO toOrderModel(Order order) {
		
		OrderDTO orderDto = new OrderDTO();
		orderDto.setOrderItem(order.getOrderItem());		
		return orderDto;
	}

	public static Order toViewOrder(OrderDTO dto) {
		Order order =new Order();
		order.setOrderid(dto.getOrderid());
		order.setOrderItem(dto.getOrderItem());
		order.setPersonId(dto.getPerson().getPersonid());
		return order;
	}
	
	
}
