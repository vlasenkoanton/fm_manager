package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client extends Person {

	@Column(name = "responsible")
	private String responsible;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fop_id")
	private EntrepreneurInfo entrepreneurInfo;

	@Column(name = "pep", nullable = false)
	private boolean pep;

	//@OneToMany(mappedBy = "owner")
	//private List<Account> accountList;

	public Client() {
	}

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public EntrepreneurInfo getEntrepreneurInfo() {
		return entrepreneurInfo;
	}

	public void setEntrepreneurInfo(EntrepreneurInfo entrepreneurInfo) {
		this.entrepreneurInfo = entrepreneurInfo;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
