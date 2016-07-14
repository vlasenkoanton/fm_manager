package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "work")
@NamedQueries({
        @NamedQuery(name = Work.GET_BY_CLIENT, query = "SELECT c.work FROM Client c " +
                "WHERE c.work.id=:id AND c.id=:clientId"),
        @NamedQuery(name = Work.DELETE_BY_CLIENT, query = "DELETE FROM Work w WHERE w.id=:id")
})
public class Work extends BaseEntity {
    public static final String GET_BY_CLIENT = "Work.getByClient";
    public static final String DELETE_BY_CLIENT = "Work.deleteByClient";

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
