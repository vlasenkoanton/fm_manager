package com.avlasenko.sb.fmmanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Client extends Person {
	
	private boolean pep;

	public Client() {
	}



	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
