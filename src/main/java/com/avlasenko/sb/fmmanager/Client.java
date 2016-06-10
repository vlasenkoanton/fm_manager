package com.avlasenko.sb.fmmanager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends Person {
	@Embedded
	private Contact contact;

	@OneToOne
	private Employee employee;
	
	@OneToOne
	private FmProfile fmprofile;

	@OneToMany
	private List<Related> relateds;

	@Id
	private int id;

	private String independActivity;

	@ElementCollection
	private List<String> services;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Account> accounts = new ArrayList<>();
	
	private boolean pep;

	public Client() {
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Related> getRelateds() {
		return relateds;
	}

	public void setRelateds(List<Related> relateds) {
		this.relateds = relateds;
	}

	public String getIndependActivity() {
		return independActivity;
	}

	public void setIndependActivity(String independActivity) {
		this.independActivity = independActivity;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccount(Account account) {
        this.accounts.add(account);
        if (account.getOwner() != this) {
        	account.setOwner(this);
        }
    }

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}
	
	

}
