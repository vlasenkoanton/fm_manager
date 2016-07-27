package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by A. Vlasenko on 25.07.2016.
 */
@Entity
@Table(name = "user")
@NamedQuery(name = User.GET_BY_LOGIN, query = "SELECT u FROM User u WHERE u.login=:login")
public class User extends BaseEntity {
    public static final String GET_BY_LOGIN = "User.getByLogin";

    @OneToMany(mappedBy = "responsible")
    private Set<Individual> individuals;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "office_telephone")
    private String officeTelNumber;

    @Column(name = "position")
    private String position;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<UserRole> userRoles;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getOfficeTelNumber() {
        return officeTelNumber;
    }

    public void setOfficeTelNumber(String officeTelNumber) {
        this.officeTelNumber = officeTelNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Individual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Set<Individual> individuals) {
        this.individuals = individuals;
    }
}
