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
    private Integer postCode;

    @Column(name = "country", nullable = false)
    @Max(999)
    @Min(1)
    private Integer country;

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
    private Integer house;

    @Column(name = "apartment")
    private Integer apartment;

    public Address() {
    }

    public Address(Integer id, Integer postCode, Integer country, String region, String district, String city, String street, Integer house, Integer apartment) {
        super(id);
        this.postCode = postCode;
        this.country = country;
        this.region = region;
        this.district = district;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postCode=" + postCode +
                ", country=" + country +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                "} " + super.toString();
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
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

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }
}
