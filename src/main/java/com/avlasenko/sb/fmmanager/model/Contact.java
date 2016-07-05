package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {

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
