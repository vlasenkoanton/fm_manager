package com.avlasenko.sb.fmmanager.util.dto;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Document;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
public class IndividualQuickFormDTO implements DTO {

    @Pattern(regexp = "[0-9a-zA-Z]*", message = "{validation.string.pattern.identNumber}")
    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    private String identNumber;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    @Column(name = "first_name", nullable = false)
    private String lastName;

    @Size(max = 25, message = "{validation.string.size.max}")
    @NotBlank(message = "{validation.string.notBlank}")
    private String middleName;

    @NotNull(message = "{validation.any.notNull}")
    private LocalDate dateBirth;

    private boolean resident;

    @NotNull(message = "{validation.any.notNull}")
    @Valid
    private Address address;

    @NotNull(message = "{validation.any.notNull}")
    @Valid
    private Document document;

    public IndividualQuickFormDTO() {
    }

    public IndividualQuickFormDTO(String identNumber, String firstName, String lastName, String middleName,
                                  LocalDate dateBirth, boolean resident, Address address, Document document) {
        this.identNumber = identNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateBirth = dateBirth;
        this.resident = resident;
        this.address = address;
        this.document = document;
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

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
