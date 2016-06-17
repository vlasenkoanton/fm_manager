package com.avlasenko.sb.fmmanager.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author A. Vlasenko 09.06.2016
 *
 */

@Entity
public class FmProfile {
	@Id
	private int id;

	private String serviceHistory;
	
	//Sources of client's funds
	private long monthIncome;
	private long financialHelp;
	private long securities;
	private long assignment;
	private long loans;
	private long termContracts;

	@ElementCollection
	private Map<LocalDate, Risk> risks = new HashMap<>();

	@ElementCollection
	private Map<LocalDate, Reputation> reputations = new HashMap<>();

	@ElementCollection
	private Map<LocalDate, FinancialCondition> conditions = new HashMap<>();

	public FmProfile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceHistory() {
		return serviceHistory;
	}

	public void setServiceHistory(String serviceHistory) {
		this.serviceHistory = serviceHistory;
	}
	

	public long getMonthIncome() {
		return monthIncome;
	}

	public void setMonthIncome(long monthIncome) {
		this.monthIncome = monthIncome;
	}

	public long getFinancialHelp() {
		return financialHelp;
	}

	public void setFinancialHelp(long financialHelp) {
		this.financialHelp = financialHelp;
	}

	public long getSecurities() {
		return securities;
	}

	public void setSecurities(long securities) {
		this.securities = securities;
	}

	public long getAssignment() {
		return assignment;
	}

	public void setAssignment(long assignment) {
		this.assignment = assignment;
	}

	public long getLoans() {
		return loans;
	}

	public void setLoans(long loans) {
		this.loans = loans;
	}

	public long getTermContracts() {
		return termContracts;
	}

	public void setTermContracts(long termContracts) {
		this.termContracts = termContracts;
	}

	public Map<LocalDate, Risk> getRisks() {
		return risks;
	}

	public void addRisk(Risk risk) {
		this.risks.put(LocalDate.now(), risk);
	}

	public Map<LocalDate, Reputation> getReputations() {
		return reputations;
	}

	public void addReputation(Reputation reputation) {
		this.reputations.put(LocalDate.now(), reputation);
	}

	public Map<LocalDate, FinancialCondition> getConditions() {
		return conditions;
	}

	public void addCondition(FinancialCondition condition) {
		this.conditions.put(LocalDate.now(), condition);
	}

}
