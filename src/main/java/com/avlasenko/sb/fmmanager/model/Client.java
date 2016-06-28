package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
public class Client extends Person {

	private String responsible;

	@OneToOne(cascade = CascadeType.ALL)
	private EntrepreneurInfo entrepreneurInfo;

	private boolean pep;

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
