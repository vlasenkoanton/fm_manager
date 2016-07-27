package com.avlasenko.sb.fmmanager.model;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "individual")
@NamedEntityGraph(name = Individual.ALL_RELATIONS, attributeNodes = {
        @NamedAttributeNode("address"),
        @NamedAttributeNode("documents"),
        @NamedAttributeNode("work"),
        @NamedAttributeNode("contact"),
        @NamedAttributeNode("fmInfo"),
        @NamedAttributeNode("entrepreneurInfo"),
        @NamedAttributeNode("accOpener"),
        @NamedAttributeNode("representative"),
        @NamedAttributeNode("accounts")
})
@NamedQueries({
        @NamedQuery(name = Individual.WITHOUT_RELATIONS, query = "UPDATE Individual i SET identNumber=:identNumber," +
                " firstName=:firstName, lastName=:lastName, middleName=:middleName," +
                "dateBirth=:dateBirth, placeBirth=:placeBirth, resident=:resident, citizenship=:citizenship, " +
                "pep=:pep WHERE i.id=:id")
})
public class Individual extends BaseEntity {
    public static final String ALL_RELATIONS = "Individual.allRelations";
    public static final String WITHOUT_RELATIONS = "Individual.withoutRelations";

    @Column(name = "client")
    private boolean client;

    @Column(name = "ident_number", nullable = false)
    private String identNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @Column(name = "place_birth", nullable = false)
    private String placeBirth;

    @Column(name = "resident", nullable = false)
    private boolean resident;

    @Column(name = "citizenship", nullable = false)
    private int citizenship;

    @Column(name = "pep", nullable = false)
    private boolean pep;

    @Column(name = "initial_profile_fill")
    private LocalDate initialProfileFill;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Document> documents;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id")
    private Work work;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fop_info_id")
    private EntrepreneurInfo entrepreneurInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fm_info_id")
    private FmInfo fmInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_opener_id")
    private Individual accOpener;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "representative_id")
    private Individual representative;

    @OneToMany(mappedBy = "owner")
    private Set<Account> accounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_id")
    private User responsible;

    public Individual() {
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPlaceBirth() {
        return placeBirth;
    }

    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public int getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(int citizenship) {
        this.citizenship = citizenship;
    }

    public boolean isPep() {
        return pep;
    }

    public void setPep(boolean pep) {
        this.pep = pep;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public EntrepreneurInfo getEntrepreneurInfo() {
        return entrepreneurInfo;
    }

    public void setEntrepreneurInfo(EntrepreneurInfo entrepreneurInfo) {
        this.entrepreneurInfo = entrepreneurInfo;
    }

    public FmInfo getFmInfo() {
        return fmInfo;
    }

    public void setFmInfo(FmInfo fmInfo) {
        this.fmInfo = fmInfo;
    }

    public Individual getAccOpener() {
        return accOpener;
    }

    public void setAccOpener(Individual accOpener) {
        this.accOpener = accOpener;
    }

    public Individual getRepresentative() {
        return representative;
    }

    public void setRepresentative(Individual representative) {
        this.representative = representative;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public LocalDate getInitialProfileFill() {
        return initialProfileFill;
    }

    public void setInitialProfileFill(LocalDate initialProfileFill) {
        this.initialProfileFill = initialProfileFill;
    }
}
