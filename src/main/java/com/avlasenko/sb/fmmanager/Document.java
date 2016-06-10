package com.avlasenko.sb.fmmanager;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document {
	@Id
	private int id;
	
	private String name;
	private String series;
	private int number;
	private String authority;
	private LocalDate dateIssue;
	private LocalDate dateExpire;
	
	public Document() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
