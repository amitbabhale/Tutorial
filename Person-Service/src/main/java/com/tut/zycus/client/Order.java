package com.tut.zycus.client;

import javax.validation.constraints.NotNull;


public class Order {

	@NotNull
	private String orderid;	
	
	@NotNull
	private String orderItem;
	
	@NotNull
	private String personId;
	
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

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
		
//	
		
}
