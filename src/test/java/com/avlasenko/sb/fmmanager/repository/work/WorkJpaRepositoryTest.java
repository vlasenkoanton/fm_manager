package com.avlasenko.sb.fmmanager.repository.work;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */
public class WorkJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private WorkJpaRepository repository;

    @Test
    public void testGetByOwner() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Work byOwner = repository.getByOwner(ownerId);
        assertEntityEquals(WORK_1, byOwner);
    }

    @Test
    public void testGetByOwnerNull() throws Exception {
        assertNull(repository.getByOwner(INDIVIDUAL_CLEAN.getId()));
    }

    @Test
    public void testSaveByOwnerNew() throws Exception {
        Work work = repository.saveByOwner(WORK_NEW, INDIVIDUAL_1.getId());
        assertEntityEquals(work, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerUpdate() throws Exception {
        repository.saveByOwner(WORK_1_UPDATED, INDIVIDUAL_1.getId());
        assertEntityEquals(WORK_1_UPDATED, repository.getByOwner(INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerNull() throws Exception {
        assertNull(repository.saveByOwner(WORK_1, INDIVIDUAL_CLEAN.getId()));
        assertNull(repository.saveByOwner(WORK_1, INDIVIDUAL_2.getId()));
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