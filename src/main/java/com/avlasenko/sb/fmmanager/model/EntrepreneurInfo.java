package com.avlasenko.sb.fmmanager.model;

import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 28.06.2016.
 */
@Entity
public class EntrepreneurInfo extends BaseEntity {

    private int regNumber;

    private String authority;
    private LocalDate regDate;

    private String activity;

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
