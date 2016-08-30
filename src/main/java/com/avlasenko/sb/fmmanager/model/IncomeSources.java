package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Embeddable
public class IncomeSources {

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "month_income")
    private Long monthIncome;

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "financial_help")
    private Long financialHelp;

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "securities")
    private Long securities;

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "assignment")
    private Long assignment;

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "loans")
    private Long loans;

    @Max(value = 9999999999999999L, message = "{validation.number.max}")
    @Digits(integer = 16, fraction = 0, message = "{validation.number.digits}")
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
