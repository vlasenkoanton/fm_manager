package com.avlasenko.sb.fmmanager.model;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @Max(value = 99, message = "{validation.number.max}")
    @Digits(integer = 2, fraction = 0, message = "{validation.number.digits}")
    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "main", nullable = false)
    private boolean main;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 10, message = "{validation.string.size.max}")
    @Column(name = "series")
    private String series;

    @Max(value = 9999999999L, message = "{validation.number.max}")
    @Digits(integer = 10, fraction = 0, message = "{validation.number.digits}")
    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "number", nullable = false)
    private Long number;

    @Size(max = 50, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "authority", nullable = false)
    private String authority;

    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "date_issue", nullable = false)
    private LocalDate dateIssue;

    @Column(name = "date_expire")
    private LocalDate dateExpire;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Individual owner;

    public Document() {
    }

    public Document(Integer type, String name, String series, Long number) {
        this.type = type;
        this.name = name;
        this.series = series;
        this.number = number;
    }

    public Document(Integer id, Integer type, boolean main, String name, String series, Long number,
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

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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
