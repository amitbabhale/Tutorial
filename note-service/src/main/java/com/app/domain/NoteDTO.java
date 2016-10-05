
package com.app.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NoteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	 
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
		
	@NotNull
	@Size(max=1000)
	private String key;
	
	@Size(max=100)
	private String subject;
		
	@Size(max=1000)
	private String text;	
	
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
	public long getId() {
		return id;
	}	
	public void setId(long id) {
		this.id = id;
	}
}
