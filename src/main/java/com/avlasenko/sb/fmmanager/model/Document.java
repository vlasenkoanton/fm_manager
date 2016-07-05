package com.avlasenko.sb.fmmanager.model;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document extends BaseEntity {

	@Column(name = "owner_id")
	private int ownerId;

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

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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

	@Override
	public String toString() {
		return "Document{" +
				"ownerId=" + ownerId +
				", type=" + type +
				", main=" + main +
				", name='" + name + '\'' +
				", series='" + series + '\'' +
				", number=" + number +
				", authority='" + authority + '\'' +
				", dateIssue=" + dateIssue +
				", dateExpire=" + dateExpire +
				'}';
	}
}
