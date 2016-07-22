package com.avlasenko.sb.fmmanager.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "document")
@NamedQueries({
		@NamedQuery(name = Document.GET_BY_CLIENT, query = "SELECT d FROM Document d " +
				"WHERE d.id=:id AND d.owner.id=:ownerId"),
		@NamedQuery(name = Document.DELETE_BY_CLIENT, query = "DELETE FROM Document d " +
				"WHERE d.id=:id AND d.owner.id=:ownerId")
})
public class Document extends BaseEntity {
	public static final String GET_BY_CLIENT = "Document.getByOwner";
	public static final String DELETE_BY_CLIENT = "Document.deleteByClient";

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Individual owner;

	@Column(name = "type", nullable = false)
	@Min(1)
	private int type;

	@Column(name = "main", nullable = false)
	private boolean main;

	@Column(name = "name", nullable = false)
	@Length(max = 25)
	@NotNull
	@NotEmpty
	private String name;

	@Column(name = "series")
	@Length(max = 25)
	private String series;

	@Column(name = "number", nullable = false)
	@Min(1)
	private int number;

	@Column(name = "authority", nullable = false)
	@Length(max = 50)
	@NotNull
	@NotEmpty
	private String authority;

	@Column(name = "date_issue", nullable = false)
	@NotNull
	private LocalDate dateIssue;

	@Column(name = "date_expire")
	private LocalDate dateExpire;
	
	public Document() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Document document = (Document) o;

		if (getType() != document.getType()) return false;
		if (getNumber() != document.getNumber()) return false;
		if (!getName().equals(document.getName())) return false;
		return getSeries().equals(document.getSeries());

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + getType();
		result = 31 * result + getName().hashCode();
		result = 31 * result + getSeries().hashCode();
		result = 31 * result + getNumber();
		return result;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public LocalDate getDateIssue() {
		return dateIssue;
	}

	public void setDateIssue(LocalDate dateIssue) {
		this.dateIssue = dateIssue;
	}

	public LocalDate getDateExpire() {
		return dateExpire;
	}

	public void setDateExpire(LocalDate dateExpire) {
		this.dateExpire = dateExpire;
	}

	public Individual getOwner() {
		return owner;
	}

	public void setOwner(Individual owner) {
		this.owner = owner;
	}

}
