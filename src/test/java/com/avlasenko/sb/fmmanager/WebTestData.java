package com.avlasenko.sb.fmmanager;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 18.08.2016.
 */
public abstract class WebTestData {
    public static final MultiValueMap<String, String> NEW_CLIENT_PARAMS = new LinkedMultiValueMap<>();
    public static final Address ADDRESS = new Address(1, 789, 840, "Texas", "none", "Dallas", "main", 5, 8);
    public static final Document DOCUMENT = new Document(1, 1, true, "passport", "KO", 365214, "usa authority", LocalDate.of(2004, 6, 7), null);
    public static final IndividualQuickFormDTO DTO = new IndividualQuickFormDTO("12365478", "Alan", "Black", "Junior", LocalDate.of(1988, 5, 6), false, ADDRESS, DOCUMENT);
    static {
        NEW_CLIENT_PARAMS.add("firstName", DTO.getFirstName());
        NEW_CLIENT_PARAMS.add("lastName", DTO.getLastName());
        NEW_CLIENT_PARAMS.add("middleName", DTO.getMiddleName());
        NEW_CLIENT_PARAMS.add("identNumber", DTO.getIdentNumber());
        NEW_CLIENT_PARAMS.add("dateBirth", String.valueOf(DTO.getDateBirth()));
        NEW_CLIENT_PARAMS.add("resident", String.valueOf(DTO.isResident()));
        NEW_CLIENT_PARAMS.add("address.postCode", String.valueOf(ADDRESS.getPostCode()));
        NEW_CLIENT_PARAMS.add("address.country", String.valueOf(ADDRESS.getCountry()));
        NEW_CLIENT_PARAMS.add("address.region", ADDRESS.getRegion());
        NEW_CLIENT_PARAMS.add("address.district", ADDRESS.getDistrict());
        NEW_CLIENT_PARAMS.add("address.city", ADDRESS.getCity());
        NEW_CLIENT_PARAMS.add("address.street", ADDRESS.getStreet());
        NEW_CLIENT_PARAMS.add("address.house", String.valueOf(ADDRESS.getHouse()));
        NEW_CLIENT_PARAMS.add("address.apartment", String.valueOf(ADDRESS.getApartment()));
        NEW_CLIENT_PARAMS.add("document.type", String.valueOf(DOCUMENT.getType()));
        NEW_CLIENT_PARAMS.add("document.name", DOCUMENT.getName());
        NEW_CLIENT_PARAMS.add("document.series", DOCUMENT.getSeries());
        NEW_CLIENT_PARAMS.add("document.number", String.valueOf(DOCUMENT.getNumber()));
        NEW_CLIENT_PARAMS.add("document.authority", DOCUMENT.getAuthority());
        NEW_CLIENT_PARAMS.add("document.dateIssue", String.valueOf(DOCUMENT.getDateIssue()));
        NEW_CLIENT_PARAMS.add("document.dateExpire", "");
        NEW_CLIENT_PARAMS.add("document.main", String.valueOf(DOCUMENT.isMain()));
    }
}
