package com.avlasenko.sb.fmmanager.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

@MappedSuperclass
public class Person extends BaseEntity {
	private int identNumber;

	private String firstName;
	private String lastName;
	private String middleName;

	private LocalDate dateBirth;
	private String placeBirth;

	private boolean resident;
	private int citizenship;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private List<Document> documents;

	@OneToOne(cascade = CascadeType.ALL)
	private Work work;

	@OneToOne(cascade = CascadeType.ALL)
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

	public List<Document> getDocuments() {
		if (this.documents == null) {
			return new ArrayList<>();
		}
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public void addDocument(Document document) {
		document.setOwnerId(this.id);
		if (document.isNew()) {
			this.getDocuments().add(document);
		} else {
			documents = documents.stream()
					.map(d -> document.getId().equals(d.getId()) ? document : d)
					.collect(Collectors.toList());
		}
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
				", documents=" + documents +
				", work=" + work +
				'}';
	}
}
