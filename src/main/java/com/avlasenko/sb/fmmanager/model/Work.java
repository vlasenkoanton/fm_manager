package com.avlasenko.sb.fmmanager.model;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "work")
@NamedQuery(name = Work.GET_BY_OWNER, query = "SELECT i.work FROM Individual i WHERE i.id=:ownerId")
public class Work extends BaseEntity {
    public static final String GET_BY_OWNER = "Work.getByOwner";

    @Size(max = 25, message = "{validation.string.size.max}")
    @Column(name = "name", nullable = false)
    private String name;

    @Max(value = 9999999999L, message = "{validation.number.max}")
    @Digits(integer = 10, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "identification_code")
    private Long identCode;

    @Size(max = 25, message = "{validation.string.size.max}")
    @Column(name = "position")
    private String position;

    public Work() {
    }

    public Work(Integer id, String name, Long identCode, String position) {
        super(id);
        this.name = name;
        this.identCode = identCode;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", identCode=" + identCode +
                ", position='" + position + '\'' +
                "} " + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdentCode() {
        return identCode;
    }

    public void setIdentCode(Long identCode) {
        this.identCode = identCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
