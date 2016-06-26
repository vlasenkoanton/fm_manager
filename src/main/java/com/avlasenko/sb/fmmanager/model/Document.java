package com.avlasenko.sb.fmmanager.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Document extends BaseEntity {

	@Column(name = "owner_id")
	private int ownerId;

	private int type;
	private boolean main;

	private String name;
	private String series;
	private int number;
	private String authority;

	private LocalDate dateIssue;
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
