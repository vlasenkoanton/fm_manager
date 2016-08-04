package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Embeddable
public class IncomeSources {

    @Column(name = "month_income")
    private Long monthIncome;

    @Column(name = "financial_help")
    private Long financialHelp;

    @Column(name = "securities")
    private Long securities;

    @Column(name = "assignment")
    private Long assignment;

    @Column(name = "loans")
    private Long loans;

    @Column(name = "term_contracts")
    private Long termContracts;

    public IncomeSources() {
    }

    public IncomeSources(Long monthIncome, Long financialHelp, Long securities, Long assignment, Long loans, Long termContracts) {
        this.monthIncome = monthIncome;
        this.financialHelp = financialHelp;
        this.securities = securities;
        this.assignment = assignment;
        this.loans = loans;
        this.termContracts = termContracts;
    }

    @Override
    public String toString() {
        return "IncomeSources{" +
                "monthIncome=" + monthIncome +
                ", financialHelp=" + financialHelp +
                ", securities=" + securities +
                ", assignment=" + assignment +
                ", loans=" + loans +
                ", termContracts=" + termContracts +
                '}';
    }

    public Long getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Long monthIncome) {
        this.monthIncome = monthIncome;
    }

    public Long getFinancialHelp() {
        return financialHelp;
    }

    public void setFinancialHelp(Long financialHelp) {
        this.financialHelp = financialHelp;
    }

    public Long getSecurities() {
        return securities;
    }

    public void setSecurities(Long securities) {
        this.securities = securities;
    }

    public Long getAssignment() {
        return assignment;
    }

    public void setAssignment(Long assignment) {
        this.assignment = assignment;
    }

    public Long getLoans() {
        return loans;
    }

    public void setLoans(Long loans) {
        this.loans = loans;
    }

    public Long getTermContracts() {
        return termContracts;
    }

    public void setTermContracts(Long termContracts) {
        this.termContracts = termContracts;
    }
}
