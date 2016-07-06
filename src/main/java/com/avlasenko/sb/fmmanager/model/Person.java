package com.avlasenko.sb.fmmanager.model;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person extends BaseEntity {

	@Column(name = "ident_number")
	private int identNumber;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "date_birth", nullable = false)
	private LocalDate dateBirth;

	@Column(name = "place_birth", nullable = false)
	private String placeBirth;

	@Column(name = "resident", nullable = false)
	private boolean resident;

	@Column(name = "citizenship", nullable = false)
	private int citizenship;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", updatable = false, insertable = false)
	private Address address;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "work_id", updatable = false, insertable = false)
	private Work work;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", updatable = false, insertable = false)
	private Contact contact;


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

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Person{" +
				"identNumber=" + identNumber +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", dateBirth=" + dateBirth +
				", placeBirth='" + placeBirth + '\'' +
				", resident=" + resident +
				", citizenship=" + citizenship +
				", address=" + address +
				", work=" + work +
				'}';
	}
}
