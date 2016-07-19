package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@NamedEntityGraph(name = Client.GRAPH, attributeNodes = {
		@NamedAttributeNode("documents"),
		@NamedAttributeNode("address"),
		@NamedAttributeNode("work"),
		@NamedAttributeNode("contact"),
		@NamedAttributeNode("entrepreneurInfo"),
		@NamedAttributeNode("fmInfo")
})
@NamedQuery(name = Client.UPDATE_WITHOUT_RELATIONS, query = "UPDATE Client c SET " +
		"c.identNumber=:identNumber, c.firstName=:firstName, c.lastName=:lastName, c.middleName=:middleName, " +
		"c.dateBirth=:dateBirth, c.placeBirth=:placeBirth, c.resident=:resident, c.citizenship=:citizenship," +
		"c.responsible=:responsible, c.pep=:pep WHERE c.id=:id") 												//TODO find more sophisticated solution
public class Client extends Person {
	public static final String GRAPH = "Client.graph";

	public static final String UPDATE_WITHOUT_RELATIONS = "Client.updateWithoutRelations";

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Document> documents;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fop_info_id")
	private EntrepreneurInfo entrepreneurInfo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fm_info_id")
	private FmInfo fmInfo;

	@Column(name = "responsible")
	private String responsible;

	@Column(name = "pep", nullable = false)
	private boolean pep;

	//@OneToMany(mappedBy = "owner")
	//private List<Account> accountList;

	public Client() {
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public EntrepreneurInfo getEntrepreneurInfo() {
		return entrepreneurInfo;
	}

	public void setEntrepreneurInfo(EntrepreneurInfo entrepreneurInfo) {
		this.entrepreneurInfo = entrepreneurInfo;
	}

	public FmInfo getFmInfo() {
		return fmInfo;
	}

	public void setFmInfo(FmInfo fmInfo) {
		this.fmInfo = fmInfo;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public boolean isPep() {
		return pep;
	}

	public void setPep(boolean pep) {
		this.pep = pep;
	}
}
