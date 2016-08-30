package com.avlasenko.sb.fmmanager.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 28.06.2016.
 */
@Entity
@Table(name = "fop_info")
@NamedQuery(name = EntrepreneurInfo.GET_BY_OWNER, query = "SELECT i.entrepreneurInfo FROM Individual i " +
        "WHERE i.id=:ownerId")
public class EntrepreneurInfo extends BaseEntity {
    public static final String GET_BY_OWNER = "EntrepreneurInfo.getByOwner";

    @Max(value = 9999999999L, message = "{validation.number.max}")
    @Digits(integer = 10, fraction = 0, message = "{validation.number.digits}")
    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "registration_number", nullable = false)
    private Long regNumber;

    @Size(max = 50, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "authority", nullable = false)
    private String authority;

    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "registration_date", nullable = false)
    private LocalDate regDate;

    @Size(max = 50, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "activity", nullable = false)
    private String activity;

    public EntrepreneurInfo() {
    }

    public EntrepreneurInfo(Integer id, Long regNumber, String authority, LocalDate regDate, String activity) {
        super(id);
        this.regNumber = regNumber;
        this.authority = authority;
        this.regDate = regDate;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "EntrepreneurInfo{" +
                "regNumber=" + regNumber +
                ", authority='" + authority + '\'' +
                ", regDate=" + regDate +
                ", activity='" + activity + '\'' +
                "} " + super.toString();
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
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
