package com.avlasenko.sb.fmmanager.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "address")
@NamedQuery(name = Address.GET_BY_OWNER, query = "SELECT i.address FROM Individual i WHERE i.id=:ownerId")
public class Address extends BaseEntity {
    public static final String GET_BY_OWNER = "Address.getByOwner";

    @Max(value = 999999, message = "{validation.number.max}")
    @Digits(integer = 6, fraction = 0, message = "{validation.number.digits}")
    @Column(name = "postal_code")
    private Integer postCode;

    @Min(value = 100, message = "{validation.number.min}")
    @Max(value = 999, message = "{validation.number.max}")
    @Digits(integer = 3, fraction = 0, message = "{validation.number.digits}")
    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "country", nullable = false)
    private Integer country;

    @Size(max = 25, message = "{validation.string.size.max}")
    @Column(name = "region")
    private String region;

    @Size(max = 25, message = "{validation.string.size.max}")
    @Column(name = "district")
    private String district;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "city", nullable = false)
    private String city;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "street", nullable = false)
    private String street;

    @Max(value = 999999, message = "{validation.number.max}")
    @Digits(integer = 6, fraction = 0, message = "{validation.number.digits}")
    @NotNull(message = "{validation.any.notNull}")
    @Column(name = "house", nullable = false)
    private Integer house;

    @Max(value = 999999, message = "{validation.number.max}")
    @Digits(integer = 6, fraction = 0, message = "{validation.number.digits}")
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
