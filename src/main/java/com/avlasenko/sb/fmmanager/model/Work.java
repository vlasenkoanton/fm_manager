package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class Work extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "identification_code")
	private int identCode;

	@Column(name = "position")
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
