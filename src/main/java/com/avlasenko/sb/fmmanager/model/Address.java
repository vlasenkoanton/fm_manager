package com.avlasenko.sb.fmmanager.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@NamedQuery(name = Address.GET_BY_OWNER, query = "SELECT i.address FROM Individual i WHERE i.id=:ownerId")
public class Address extends BaseEntity {
    public static final String GET_BY_OWNER = "Address.getByOwner";

    @Column(name = "postal_code")
    private int postCode;

    @Column(name = "country", nullable = false)
    @Max(999)
    @Min(1)
    private int country;

    @Column(name = "region")
    @Length(max = 25)
    private String region;

    @Column(name = "district")
    @Length(max = 25)
    private String district;

    @Column(name = "city", nullable = false)
    @NotNull
    @NotEmpty
    @Length(max = 25)
    private String city;

    @Column(name = "street", nullable = false)
    @NotNull
    @NotEmpty
    @Length(max = 25)
    private String street;

    @Column(name = "house", nullable = false)
    @Min(1)
    private int house;

    @Column(name = "apartment")
    private int apartment;

    public Address() {

    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
