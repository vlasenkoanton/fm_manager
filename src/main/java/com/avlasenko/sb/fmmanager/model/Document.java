package com.avlasenko.sb.fmmanager.model;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "document")
@NamedQueries({
		@NamedQuery(name = Document.GET_BY_CLIENT, query = "SELECT d FROM Document d " +
				"WHERE d.id=:id AND d.client.id=:ownerId"),
		@NamedQuery(name = Document.DELETE_BY_CLIENT, query = "DELETE FROM Document d " +
				"WHERE d.id=:id AND d.client.id=:clientId")
})
public class Document extends BaseEntity {
	public static final String GET_BY_CLIENT = "Document.getByOwner";
	public static final String DELETE_BY_CLIENT = "Document.deleteByClient";

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "type", nullable = false)
	private int type;

	@Column(name = "main", nullable = false)
	private boolean main;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "series")
	private String series;

	@Column(name = "number", nullable = false)
	private int number;

	@Column(name = "authority", nullable = false)
	private String authority;

	@Column(name = "date_issue", nullable = false)
	private LocalDate dateIssue;

	@Column(name = "date_expire")
	private LocalDate dateExpire;
	
	public Document() {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Document document = (Document) o;

		if (type != document.type) return false;
		if (number != document.number) return false;
		return series != null ? series.equals(document.series) : document.series == null;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + type;
		result = 31 * result + (series != null ? series.hashCode() : 0);
		result = 31 * result + number;
		return result;
	}


}
