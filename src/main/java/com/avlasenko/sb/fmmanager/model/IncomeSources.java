package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Embeddable
public class IncomeSources {

    @Column(name = "month_income")
    private long monthIncome;

    @Column(name = "financial_help")
    private long financialHelp;

    @Column(name = "securities")
    private long securities;

    @Column(name = "assignment")
    private long assignment;

    @Column(name = "loans")
    private long loans;

    @Column(name = "term_contracts")
    private long termContracts;

    public IncomeSources() {
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
}
