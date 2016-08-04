package com.avlasenko.sb.fmmanager.model;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "document")
@NamedQueries({
        @NamedQuery(name = Document.GET_BY_CLIENT, query = "SELECT d FROM Document d " +
                "WHERE d.id=:id AND d.owner.id=:ownerId"),
        @NamedQuery(name = Document.DELETE_BY_CLIENT, query = "DELETE FROM Document d " +
                "WHERE d.id=:id AND d.owner.id=:ownerId")
})
public class Document extends BaseEntity {
    public static final String GET_BY_CLIENT = "Document.getByOwner";
    public static final String DELETE_BY_CLIENT = "Document.deleteByClient";

    @Column(name = "type", nullable = false)
    @Min(1)
    private Integer type;

    @Column(name = "main", nullable = false)
    private boolean main;

    @Column(name = "name", nullable = false)
    @Length(max = 25)
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "series")
    @Length(max = 25)
    private String series;

    @Column(name = "number", nullable = false)
    @Min(1)
    private Integer number;

    @Column(name = "authority", nullable = false)
    @Length(max = 50)
    @NotNull
    @NotEmpty
    private String authority;

    @Column(name = "date_issue", nullable = false)
    @NotNull
    private LocalDate dateIssue;

    @Column(name = "date_expire")
    private LocalDate dateExpire;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Individual owner;

    public Document() {
    }

    public Document(Integer type, String name, String series, Integer number) {
        this.type = type;
        this.name = name;
        this.series = series;
        this.number = number;
    }

    public Document(Integer id, Integer type, boolean main, String name, String series, Integer number,
                    String authority, LocalDate dateIssue, LocalDate dateExpire) {
        super(id);
        this.type = type;
        this.main = main;
        this.name = name;
        this.series = series;
        this.number = number;
        this.authority = authority;
        this.dateIssue = dateIssue;
        this.dateExpire = dateExpire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (getType() != null ? !getType().equals(document.getType()) : document.getType() != null) return false;
        if (getName() != null ? !getName().equals(document.getName()) : document.getName() != null) return false;
        if (getSeries() != null ? !getSeries().equals(document.getSeries()) : document.getSeries() != null)
            return false;
        return getNumber() != null ? getNumber().equals(document.getNumber()) : document.getNumber() == null;

    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSeries() != null ? getSeries().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Document{" +
                "type=" + type +
                ", main=" + main +
                ", name='" + name + '\'' +
                ", series='" + series + '\'' +
                ", number=" + number +
                ", authority='" + authority + '\'' +
                ", dateIssue=" + dateIssue +
                ", dateExpire=" + dateExpire +
                "} " + super.toString();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public LocalDate getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(LocalDate dateExpire) {
        this.dateExpire = dateExpire;
    }

    public Individual getOwner() {
        return owner;
    }

    public void setOwner(Individual owner) {
        this.owner = owner;
    }
}
