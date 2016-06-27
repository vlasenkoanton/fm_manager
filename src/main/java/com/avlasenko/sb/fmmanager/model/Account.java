package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author A. Vlasenko 09.06.2016
 *
 */


public class Account {

	private int id;

	private long number;
	private long balance;
	

	private Client owner;

	public Account() {
	}



}
