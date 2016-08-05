package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */


public class AddressJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private AddressJpaRepository repository;

    @Test
    public void testGetByOwner() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Address byOwner = repository.getByOwner(ownerId);
        assertEntityEquals(ADDRESS_1, byOwner);
    }

    @Test
    public void testGetByOwnerNull() throws Exception {
        assertNull(repository.getByOwner(INDIVIDUAL_CLEAN.getId()));
    }

    @Test
    public void testSaveByOwnerNew() throws Exception {
        Address address = repository.saveByOwner(ADDRESS_NEW, INDIVIDUAL_1.getId());
        assertEntityEquals(address, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerUpdate() throws Exception {
        repository.saveByOwner(ADDRESS_1_UPDATED, INDIVIDUAL_1.getId());
        assertEntityEquals(ADDRESS_1_UPDATED, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerNull() throws Exception {
        assertNull(repository.saveByOwner(ADDRESS_1, INDIVIDUAL_CLEAN.getId()));
        assertNull(repository.saveByOwner(ADDRESS_1, INDIVIDUAL_2.getId()));
    }

    @Test
    public void testDeleteByOwner() throws Exception {
        assertTrue(repository.deleteByOwner(INDIVIDUAL_1.getId()));
        assertNull(repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testDeleteByOwnerFalse() throws Exception {
        assertFalse(repository.deleteByOwner(INDIVIDUAL_CLEAN.getId()));
    }
}