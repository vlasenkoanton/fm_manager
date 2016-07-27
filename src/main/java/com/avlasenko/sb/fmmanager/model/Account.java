package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author A. Vlasenko 09.06.2016
 *
 */

@Entity
@Table(name = "account")
public class Account extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Individual owner;

	@Column(name = "name")
	private String name;

	@Column(name = "number")
	private long number;

	@Column(name = "balance")
	private long balance;

	@Column(name = "opened")
	private LocalDateTime opened;

	@Column(name = "updated")
	private LocalDateTime lastUpdate;

	@Column(name = "closed")
	private LocalDateTime closed;

	public Account() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Account account = (Account) o;

		return getNumber() == account.getNumber();

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (int) (number ^ (number >>> 32));
		return result;
	}

	public Individual getOwner() {
		return owner;
	}

	public void setOwner(Individual owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
