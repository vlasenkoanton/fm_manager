package com.avlasenko.sb.fmmanager.repository.individual;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 03.08.2016.
 */
public class IndividualJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private IndividualJpaRepository repository;

    @Test
    public void testSave() throws Exception {
        repository.save(INDIVIDUAL_NEW);
        Individual fromDb = repository.get(INDIVIDUAL_NEW.getId());
        assertEntityEquals(INDIVIDUAL_NEW, fromDb);
    }

    @Test
    public void testMerge() throws Exception {
        INDIVIDUAL_1_COPY.setFirstName("testMerge");
        repository.save(INDIVIDUAL_1_COPY);
        Individual individual = repository.get(INDIVIDUAL_1_COPY.getId());
        assertEntityEquals(INDIVIDUAL_1_COPY, individual);
    }

    @Test
    public void testGet() throws Exception {
        Individual individual = repository.get(INDIVIDUAL_1.getId());
        assertEntityEquals(INDIVIDUAL_1, individual);
    }

    @Test
    public void testGetAll() throws Exception {
        Collection<Individual> all = repository.getAll();
        assertCollectionEquals(ALL_INDIVIDUALS, all);
    }

    @Test
    public void testDelete() throws Exception {
        ArrayList<Individual> individuals = new ArrayList<>(ALL_INDIVIDUALS);
        individuals.remove(INDIVIDUAL_1);
        repository.delete(INDIVIDUAL_1.getId());
        assertCollectionEquals(individuals, repository.getAll());
    }

    @Test
    public void testGetWithAllProperties() throws Exception {
        Individual individual = repository.getWithAllProperties(1);
        assertDeepEquals(INDIVIDUAL_1, individual);
    }

    @Test
    public void testGetWithAllPropertiesNull() throws Exception {
        assertNull(repository.getWithAllProperties(NONEXISTENT_ID));
    }

    @Test
    public void testUpdateWithoutRelations() throws Exception {
        repository.save(INDIVIDUAL_NEW);

        //fields that are not updated by method IndividualRepository.updateWithoutRelations
        boolean client = INDIVIDUAL_1.isClient();
        LocalDate initialProfileFill = INDIVIDUAL_1.getInitialProfileFill();

        //save id for avoiding violation test data
        Integer id_saved = INDIVIDUAL_1.getId();
        INDIVIDUAL_1.setId(INDIVIDUAL_NEW.getId());

        repository.updateWithoutRelations(INDIVIDUAL_1, INDIVIDUAL_1.getId());

        Individual actual = repository.get(INDIVIDUAL_1.getId());
        actual.setClient(client);
        actual.setInitialProfileFill(initialProfileFill);

        assertEntityEquals(INDIVIDUAL_1, actual);
        INDIVIDUAL_1.setId(id_saved);
    }

    @Test
    public void testUpdateWithoutRelationsNull() throws Exception {
        Integer id_saved = INDIVIDUAL_1.getId();
        INDIVIDUAL_1.setId(null);
        assertNull(repository.updateWithoutRelations(INDIVIDUAL_1, 1));
        INDIVIDUAL_1.setId(id_saved);

        assertNull(repository.updateWithoutRelations(INDIVIDUAL_1, NONEXISTENT_ID));
    }

    @Test
    public void testSaveAccOpener() throws Exception {
        Individual accOpener = repository.saveAccOpener(PROXY, INDIVIDUAL_1.getId());
        Individual withAllProperties = repository.getWithAllProperties(INDIVIDUAL_1.getId());
        assertEntityEquals(accOpener, withAllProperties.getAccOpener());
        PROXY.setId(null);
    }

    @Test
    public void testSaveAccOpenerNull() throws Exception {
        PROXY.setId(4);
        assertNull(repository.saveAccOpener(PROXY, INDIVIDUAL_1.getId()));
        assertNull(repository.saveRepresentative(PROXY, INDIVIDUAL_1.getId()));

        PROXY.setId(null);
        assertNull(repository.saveAccOpener(PROXY, NONEXISTENT_ID));
        assertNull(repository.saveRepresentative(PROXY, NONEXISTENT_ID));
    }

    @Test
    public void testSaveRepresentative() throws Exception {
        Individual representative = repository.saveRepresentative(PROXY, INDIVIDUAL_1.getId());
        Individual withAllProperties = repository.getWithAllProperties(INDIVIDUAL_1.getId());
        assertEntityEquals(representative, withAllProperties.getRepresentative());
        PROXY.setId(null);
    }
}