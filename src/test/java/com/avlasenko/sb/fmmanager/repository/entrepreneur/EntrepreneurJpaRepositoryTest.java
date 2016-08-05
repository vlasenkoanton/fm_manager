package com.avlasenko.sb.fmmanager.repository.entrepreneur;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */
public class EntrepreneurJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private EntrepreneurJpaRepository repository;

    @Test
    public void testGetByOwner() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        EntrepreneurInfo byOwner = repository.getByOwner(ownerId);
        assertEntityEquals(ENTREPRENEUR_INFO_1, byOwner);
    }

    @Test
    public void testGetByOwnerNull() throws Exception {
        assertNull(repository.getByOwner(INDIVIDUAL_CLEAN.getId()));
    }

    @Test
    public void testSaveByOwnerNew() throws Exception {
        EntrepreneurInfo entrepreneurInfo = repository.saveByOwner(ENTREPRENEUR_INFO_NEW, INDIVIDUAL_1.getId());
        assertEntityEquals(entrepreneurInfo, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerUpdate() throws Exception {
        repository.saveByOwner(ENTREPRENEUR_INFO_1_UPDATED, INDIVIDUAL_1.getId());
        assertEntityEquals(ENTREPRENEUR_INFO_1_UPDATED, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerNull() throws Exception {
        assertNull(repository.saveByOwner(ENTREPRENEUR_INFO_1, INDIVIDUAL_CLEAN.getId()));
        assertNull(repository.saveByOwner(ENTREPRENEUR_INFO_1, INDIVIDUAL_2.getId()));
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