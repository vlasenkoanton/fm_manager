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
    private int identCode;

    @Column(name = "position")
    private String position;

    public Work() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentCode() {
        return identCode;
    }

    public void setIdentCode(int identCode) {
        this.identCode = identCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
