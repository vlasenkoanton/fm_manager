package com.avlasenko.sb.fmmanager.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contact")
@NamedQuery(name = Contact.GET_BY_OWNER, query = "SELECT i.contact FROM Individual i WHERE i.id=:ownerId")
public class Contact extends BaseEntity {
	public static final String GET_BY_OWNER = "Contact.getByOwner";

	@Size(max = 25, message = "{validation.string.size.max}")
	@Column(name = "home_telephone")
	private String homeTel;

	@Size(max = 25, message = "{validation.string.size.max}")
	@Column(name = "work_telephone")
	private String workTel;

	@Size(max = 25, message = "{validation.string.size.max}")
	@NotBlank(message = "{validation.string.notBlank}")
	@Column(name = "mobile_telephone", nullable = false)
	private String mobileTel;

	@Size(max = 25, message = "{validation.string.size.max}")
	@Column(name = "fax")
	private String fax;

	@Email
	@Column(name = "email")
	private String email;

	public Contact() {
	}

	public Contact(Integer id, String homeTel, String workTel, String mobileTel, String fax, String email) {
		super(id);
		this.homeTel = homeTel;
		this.workTel = workTel;
		this.mobileTel = mobileTel;
		this.fax = fax;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"homeTel='" + homeTel + '\'' +
				", workTel='" + workTel + '\'' +
				", mobileTel='" + mobileTel + '\'' +
				", fax='" + fax + '\'' +
				", email='" + email + '\'' +
				"} " + super.toString();
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
