/**
 * 
 */
package com.tut.zycus.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import com.tut.zycus.client.AddressType;

/**
 * @author amit
 *
 */
@Embeddable
public class AddressDTO {
	
	@Size(max = 10)
	String Type = AddressType.Home.toString();
	
	@Size(max = 25)
	String line1;
	
	@Size(max = 25)
	String line2;
	
	@Size(max = 25)
	String line3;

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
}
