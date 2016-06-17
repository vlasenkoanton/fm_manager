package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Related extends Person {
	@Id
	private int id;

	private int relationType;
	
	private boolean pep;

	public Related() {
	}

	public int getRelationType() {
		return relationType;
	}

	public void setRelationType(int relationType) {
		this.relationType = relationType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}

	
}
