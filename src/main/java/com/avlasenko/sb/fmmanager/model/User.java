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
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "responsible")
    private Set<Individual> individuals;

    public User() {
    }

    public User(Integer id, String login, String password, String firstName, String lastName, String middleName, String officeTelNumber, String position, Set<UserRole> userRoles) {
        super(id);
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.officeTelNumber = officeTelNumber;
        this.position = position;
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", officeTelNumber='" + officeTelNumber + '\'' +
                ", position='" + position + '\'' +
                ", userRoles=" + userRoles +
                "} " + super.toString();
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
