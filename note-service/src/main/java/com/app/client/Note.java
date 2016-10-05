
package com.app.client;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Note implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonProperty
	private String id;
	@JsonProperty
	private String key;
	@JsonProperty
	private String subject;
	@JsonProperty
	private String text;	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
