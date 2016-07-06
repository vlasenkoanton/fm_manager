package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@NamedQueries({
		@NamedQuery(name = Client.GET_WITH_PROPERTIES, query = "FROM Client c JOIN FETCH c.documents d FETCH ALL PROPERTIES WHERE c.id=:id GROUP BY c.id")
})
public class Client extends Person {
	public static final String GET_WITH_PROPERTIES = "Client.edit";

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Document> documents;

	@Column(name = "responsible")
	private String responsible;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fop_id", updatable = false, insertable = false)
	private EntrepreneurInfo entrepreneurInfo;

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
