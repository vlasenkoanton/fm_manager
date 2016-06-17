package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author A. Vlasenko 09.06.2016
 *
 */

@Entity
public class Account {
	@Id
	private int id;

	private long number;
	private long balance;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client owner;

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
        if (!owner.getAccounts().contains(this)) { 
        	owner.getAccounts().add(this);
        }
	}

}
