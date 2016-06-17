package com.avlasenko.sb.fmmanager.model;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Person {
	@OneToOne
	private Address address;
	@OneToOne
	private Document document;
	@OneToOne
	private Work work;

	private String firstName;
	private String lastName;
	private String middleName;

	private LocalDate dateBirth;
	private String placeBirth;

	private boolean resident;
	private int citizenship;

	private int identNumber;	

	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getPlaceBirth() {
		return placeBirth;
	}

	public void setPlaceBirth(String placeBirth) {
		this.placeBirth = placeBirth;
	}

	public boolean isResident() {
		return resident;
	}

	public void setResident(boolean resident) {
		this.resident = resident;
	}

	public int getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(int citizenship) {
		this.citizenship = citizenship;
	}

	public int getIdentNumber() {
		return identNumber;
	}

	public void setIdentNumber(int identNumber) {
		this.identNumber = identNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}


	@Override
	public String toString() {
		return "Person{" +
				"address=" + address +
				", document=" + document +
				", work=" + work +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", dateBirth=" + dateBirth +
				", placeBirth='" + placeBirth + '\'' +
				", resident=" + resident +
				", citizenship=" + citizenship +
				", identNumber=" + identNumber +
				'}';
	}
}
