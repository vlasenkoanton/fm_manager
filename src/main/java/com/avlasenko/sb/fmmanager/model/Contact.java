package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@NamedQueries({
		@NamedQuery(name = Contact.GET_BY_CLIENT, query = "SELECT c.contact FROM Client c " +
				"WHERE c.contact.id=:id AND c.id=:clientId"),
		@NamedQuery(name = Contact.DELETE_BY_CLIENT, query = "DELETE FROM Contact c WHERE c.id=:id")
})
public class Contact extends BaseEntity {
	public static final String GET_BY_CLIENT = "Contact.getByClient";
	public static final String DELETE_BY_CLIENT = "Contact.deleteByClient";

	@Column(name = "home_telephone")
	private String homeTel;

	@Column(name = "work_telephone")
	private String workTel;

	@Column(name = "mobile_telephone", nullable = false)
	private String mobileTel;

	@Column(name = "fax")
	private String fax;

	@Column(name = "email")
	private String email;

	public Contact() {
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getWorkTel() {
		return workTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
