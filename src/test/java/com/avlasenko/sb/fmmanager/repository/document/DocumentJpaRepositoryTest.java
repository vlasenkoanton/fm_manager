package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */
public class DocumentJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private DocumentJpaRepository repository;

    @Test
    public void testGetByOwner() throws Exception {
        Document byOwner = repository.getByOwner(DOCUMENT_1.getId(), INDIVIDUAL_1.getId());
        assertEntityEquals(DOCUMENT_1, byOwner);
    }

    @Test
    public void testGetByOwnerNull() throws Exception {
        assertNull(repository.getByOwner(DOCUMENT_1.getId(), INDIVIDUAL_2.getId()));
    }

    @Test
    public void testSaveByOwnerNew() throws Exception {
        Document document = repository.saveByOwner(DOCUMENT_NEW, INDIVIDUAL_1.getId());
        assertEntityEquals(document, repository.getByOwner(document.getId(), INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerUpdate() throws Exception {
        repository.saveByOwner(DOCUMENT_1_UPDATED, INDIVIDUAL_1.getId());
        assertEntityEquals(DOCUMENT_1_UPDATED, repository.getByOwner(DOCUMENT_1_UPDATED.getId(), INDIVIDUAL_1.getId()));
    }

    @Test
    public void testSaveByOwnerNull() throws Exception {
        assertNull(repository.saveByOwner(DOCUMENT_1, INDIVIDUAL_CLEAN.getId()));
        assertNull(repository.saveByOwner(DOCUMENT_1, INDIVIDUAL_2.getId()));
    }

    @Test
    public void testDeleteByOwner() throws Exception {
        assertTrue(repository.deleteByOwner(DOCUMENT_1.getId(), INDIVIDUAL_1.getId()));
        assertNull(repository.getByOwner(DOCUMENT_1.getId(), INDIVIDUAL_1.getId()));
    }

    @Test
    public void testDeleteByOwnerFalse() throws Exception {
        assertFalse(repository.deleteByOwner(DOCUMENT_1.getId(), INDIVIDUAL_2.getId()));
    }
}