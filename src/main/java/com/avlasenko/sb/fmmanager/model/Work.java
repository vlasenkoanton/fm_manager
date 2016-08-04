package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "work")
@NamedQuery(name = Work.GET_BY_OWNER, query = "SELECT i.work FROM Individual i WHERE i.id=:ownerId")
public class Work extends BaseEntity {
    public static final String GET_BY_OWNER = "Work.getByOwner";

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identification_code")
    private Integer identCode;

    @Column(name = "position")
    private String position;

    public Work() {
    }

    public Work(Integer id, String name, Integer identCode, String position) {
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

    public Integer getIdentCode() {
        return identCode;
    }

    public void setIdentCode(Integer identCode) {
        this.identCode = identCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
