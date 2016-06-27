package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Employee {

	private Contact contact;
	

	private int id;

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	
}
