package com.avlasenko.sb.fmmanager.repository.individual;

import com.avlasenko.sb.fmmanager.model.Individual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;

/**
 * Created by A. Vlasenko on 03.08.2016.
 */
@ActiveProfiles("test")
@ContextConfiguration({"classpath:spring/appCtx.xml", "classpath:spring/dbCtx.xml"})
@Sql(scripts = "classpath:db/tables_populate.sql", config = @SqlConfig(encoding = "UTF-8"),
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class IndividualJpaRepositoryTest {

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
        System.out.println(individual.getAddress().getId());
        assertDeepEquals(INDIVIDUAL_1, individual);
    }

    @Test
    public void testUpdateWithoutRelations() throws Exception {
        Individual ind_4 = new Individual(4, "", "", "", "", LocalDate.now(), "", false, 0, false);
        repository.save(ind_4);
        //need for avoiding violation test data
        Integer id_saved = INDIVIDUAL_1.getId();
        INDIVIDUAL_1.setId(ind_4.getId());
        repository.updateWithoutRelations(INDIVIDUAL_1, INDIVIDUAL_1_UPDATED.getId());
        INDIVIDUAL_1.setId(id_saved);

        assertEntityEquals(INDIVIDUAL_1_UPDATED, repository.get(INDIVIDUAL_1_UPDATED.getId()));
    }

    @Test
    public void testSaveAccOpener() throws Exception {
        Individual accOpener = repository.saveAccOpener(PROXY, INDIVIDUAL_1.getId());
        Individual withAllProperties = repository.getWithAllProperties(INDIVIDUAL_1.getId());
        assertEntityEquals(accOpener, withAllProperties.getAccOpener());
        PROXY.setId(null);
    }

    @Test
    public void testSaveRepresentative() throws Exception {
        Individual representative = repository.saveRepresentative(PROXY, INDIVIDUAL_1.getId());
        Individual withAllProperties = repository.getWithAllProperties(INDIVIDUAL_1.getId());
        assertEntityEquals(representative, withAllProperties.getRepresentative());
        PROXY.setId(null);
    }
}