package com.avlasenko.sb.fmmanager.util.dto.converter;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;

import static com.avlasenko.sb.fmmanager.util.TestUtils.assertDeepEquals;

/**
 * Created by A. Vlasenko on 10.08.2016.
 */
public class DTOConverterTest {

    @Test
    public void testConvertDtoToIndividual() throws Exception {
        String identNumber = "id111";
        String firstName = "John";
        String lastName = "Smith";
        String middleName = null;
        LocalDate dateBirth = LocalDate.of(2001, 5, 15);
        boolean resident = true;
        Document document =
                new Document(null, 1, true, "passport", "KK", 123654, "authority", LocalDate.of(2000, 7, 2), null);
        Address address = new Address(null, 125487, 980, "region", "district", "city", "street", 5, 6);

        IndividualQuickFormDTO dto = new IndividualQuickFormDTO(
                identNumber, firstName, lastName, middleName, dateBirth, resident, address, document);

        Individual expected = new Individual();
        expected.setIdentNumber(identNumber);
        expected.setFirstName(firstName);
        expected.setLastName(lastName);
        expected.setMiddleName(middleName);
        expected.setDateBirth(dateBirth);
        expected.setResident(resident);
        expected.setAddress(address);
        expected.setDocuments(Collections.singleton(document));

        Individual actual = DTOConverter.convertToEntity(dto);

        assertDeepEquals(expected, actual);
    }

}