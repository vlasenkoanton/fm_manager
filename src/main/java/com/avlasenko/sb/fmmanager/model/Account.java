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

	@Column(name = "name")
	private String name;

	@Column(name = "number")
	private Long number;

	@Column(name = "balance")
	private Long balance;

	@Column(name = "opened")
	private LocalDateTime opened;

	@Column(name = "updated")
	private LocalDateTime lastUpdate;

	@Column(name = "closed")
	private LocalDateTime closed;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Individual owner;

	public Account() {
	}

	public Account(Integer id, String name, Long number, Long balance, LocalDateTime opened, LocalDateTime lastUpdate, LocalDateTime closed) {
		super(id);
		this.name = name;
		this.number = number;
		this.balance = balance;
		this.opened = opened;
		this.lastUpdate = lastUpdate;
		this.closed = closed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Account account = (Account) o;

		return getNumber().equals(account.getNumber());
	}

	@Override
	public String toString() {
		return "Account{" +
				"name='" + name + '\'' +
				", number=" + number +
				", balance=" + balance +
				", opened=" + opened +
				", lastUpdate=" + lastUpdate +
				", closed=" + closed +
				"} " + super.toString();
	}

	@Override
	public int hashCode() {
		return getNumber().hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
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

	public Individual getOwner() {
		return owner;
	}

	public void setOwner(Individual owner) {
		this.owner = owner;
	}
}
