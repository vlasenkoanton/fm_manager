package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Work extends BaseEntity {
	
	private String name;
	private int identCode;
	private String position;
	
	public Work() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdentCode() {
		return identCode;
	}

	public void setIdentCode(int identCode) {
		this.identCode = identCode;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
}
