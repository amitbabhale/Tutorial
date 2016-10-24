/**
 * 
 */
package com.tut.zycus.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tut.zycus.client.Order;
import com.tut.zycus.client.Person;
import com.tut.zycus.util.Mapper;

/**
 * @author amit
 *
 */
@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	public Person save(PersonDTO personModel){
		
		Person personView = Mapper.apply(personRepository.save(personModel));
		return personView;
		
	}

	public Person getPerson(String personID) {
		Person personView = Mapper.apply(personRepository.findOne(personID));
		return personView;
	}

	public Order saveOrder(String personID, Order order) {
		
		Person person = getPerson(personID);
		PersonDTO personDto = Mapper.apply(person);
		
		OrderDTO orderDto = Mapper.toOrderModel(order);
		orderDto.setPersonDto(personDto);
		OrderDTO result = orderRepository.save(orderDto);
				
		return Mapper.toViewOrder(result);		
	}
	

}
