package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
@NamedQueries({
        @NamedQuery(name = Address.GET_BY_CLIENT, query = "SELECT c.address FROM Client c " +
                "WHERE c.address.id=:id AND c.id=:clientId"),
        @NamedQuery(name = Address.DELETE_BY_CLIENT, query = "DELETE FROM Address a WHERE a.id=:id")
})
public class Address extends BaseEntity {
    public static final String GET_BY_CLIENT = "Address.getByClient";
    public static final String DELETE_BY_CLIENT = "Address.deleteByClient";

    @Column(name = "postal_code")
    private int postCode;

    @Column(name = "country", nullable = false)
    private int country;

    @Column(name = "region")
    private String region;

    @Column(name = "district")
    private String district;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house", nullable = false)
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
