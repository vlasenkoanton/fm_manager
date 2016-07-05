package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author A. Vlasenko 09.06.2016
 *
 */

//@Entity
//@Table(name = "account")
public class Account extends BaseEntity {

	private long number;
	private long balance;

	private LocalDateTime opened;
	private LocalDateTime lastUpdate = LocalDateTime.now();
	private LocalDateTime closed;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private Client owner;*/

	public Account() {
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

	public LocalDateTime getOpened() {
		return opened;
	}

	public void setOpened(LocalDateTime opened) {
		this.opened = opened;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public LocalDateTime getClosed() {
		return closed;
	}

	public void setClosed(LocalDateTime closed) {
		this.closed = closed;
	}

	/*public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}*/
}
