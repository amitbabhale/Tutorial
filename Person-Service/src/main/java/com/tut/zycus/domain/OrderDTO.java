package com.tut.zycus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ORDER_DETAIL")
public class OrderDTO {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "order_id")	
	private String orderid;	
	
	private String orderItem;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private PersonDTO personDto;

	public PersonDTO getPersonDto() {
		return personDto;
	}

	public void setPersonDto(PersonDTO personDto) {
		this.personDto = personDto;
	}

}
