package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 28.06.2016.
 */
@Entity
@Table(name = "fop_info")
public class EntrepreneurInfo extends BaseEntity {

    @Column(name = "registration_number", nullable = false)
    private int regNumber;

    @Column(name = "authority", nullable = false)
    private String authority;

    @Column(name = "registration_date", nullable = false)
    private LocalDate regDate;

    @Column(name = "activity", nullable = false)
    private String activity;

    public EntrepreneurInfo() {
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
