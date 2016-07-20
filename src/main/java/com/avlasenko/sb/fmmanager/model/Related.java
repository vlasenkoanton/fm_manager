package com.avlasenko.sb.fmmanager.model;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "related")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rel_type")
@DiscriminatorValue("related")
@NamedEntityGraph(name = Related.RELATED_GET_WITH_RELATIONS, attributeNodes = {
		@NamedAttributeNode("address"),
		@NamedAttributeNode("documents")
})
@NamedQueries({
		@NamedQuery(name = Related.RELATED_UPDATE_WITHOUT_RELATIONS, query = "UPDATE Related r SET " +
				"r.identNumber=:identNumber, r.firstName=:firstName, r.lastName=:lastName, r.middleName=:middleName, " +
				"r.dateBirth=:dateBirth, r.placeBirth=:placeBirth, r.resident=:resident, r.citizenship=:citizenship " +
				"WHERE r.id=:id"),																							//TODO find more sophisticated solution
		@NamedQuery(name = Related.GET_OPENER_BY_CLIENT, query = "SELECT c.accOpener FROM Client c " +
				"WHERE c.accOpener.id=:id AND c.id=:clientId"),
		@NamedQuery(name = Related.GET_REPRESENTATIVE_BY_CLIENT, query = "SELECT c.representative FROM Client c " +
				"WHERE c.representative.id=:id AND c.id=:clientId"),
		@NamedQuery(name = Related.DELETE_BY_CLIENT, query = "DELETE FROM Related r WHERE r.id=:id")
})
public class Related extends BaseEntity {
	public static final String RELATED_GET_WITH_RELATIONS = "Related.getWithRelations";
	public static final String RELATED_UPDATE_WITHOUT_RELATIONS = "Related.updateWithoutRelations";
	public static final String GET_OPENER_BY_CLIENT = "Related.getOpenerByClient";
	public static final String GET_REPRESENTATIVE_BY_CLIENT = "Related.getRepresentativeByClient";
	public static final String DELETE_BY_CLIENT = "Related.deleteByClient";

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
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	private Set<Document> documents;

	public Related() {
	}

	public int getIdentNumber() {
		return identNumber;
	}

	public void setIdentNumber(int identNumber) {
		this.identNumber = identNumber;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
}
