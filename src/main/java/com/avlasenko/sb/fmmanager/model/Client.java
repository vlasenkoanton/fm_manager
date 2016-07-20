package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedEntityGraph(name = Client.CLIENT_GET_WITH_RELATIONS, attributeNodes = {
		@NamedAttributeNode("documents"),
		@NamedAttributeNode("address"),
		@NamedAttributeNode("work"),
		@NamedAttributeNode("contact"),
		@NamedAttributeNode("entrepreneurInfo"),
		@NamedAttributeNode("fmInfo"),
		@NamedAttributeNode("accOpener"),
		@NamedAttributeNode("representative")
})
@NamedQuery(name = Client.CLIENT_UPDATE_WITHOUT_RELATIONS, query = "UPDATE Client c SET " +
		"c.identNumber=:identNumber, c.firstName=:firstName, c.lastName=:lastName, c.middleName=:middleName, " +
		"c.dateBirth=:dateBirth, c.placeBirth=:placeBirth, c.resident=:resident, c.citizenship=:citizenship," +
		"c.responsible=:responsible, c.pep=:pep WHERE c.id=:id") 												//TODO find more sophisticated solution
public class Client extends Related {
	public static final String CLIENT_GET_WITH_RELATIONS = "Client.getWithRelations";
	public static final String CLIENT_UPDATE_WITHOUT_RELATIONS = "Client.updateWithoutRelations";

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "work_id")
	private Work work;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private Contact contact;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fop_info_id")
	private EntrepreneurInfo entrepreneurInfo;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fm_info_id")
	private FmInfo fmInfo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_opener_id")
	private Related accOpener;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "representative_id")
	private Related representative;

	@Column(name = "responsible")
	private String responsible;

	@Column(name = "pep", nullable = false)
	private boolean pep;

	//@OneToMany(mappedBy = "owner")
	//private List<Account> accountList;

	public Client() {
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

	public Related getAccOpener() {
		return accOpener;
	}

	public void setAccOpener(Related accOpener) {
		this.accOpener = accOpener;
	}

	public Related getRepresentative() {
		return representative;
	}

	public void setRepresentative(Related representative) {
		this.representative = representative;
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
