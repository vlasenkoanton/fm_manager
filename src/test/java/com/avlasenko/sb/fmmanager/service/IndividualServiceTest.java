package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepository;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 08.08.2016.
 */
public class IndividualServiceTest {
    Individual individual;

    IndividualService service;

    IndividualJpaRepository individualRepositoryMock;
    UserJpaRepository userRepositoryMock;

    @Before
    public void setUp() {
        individual = new Individual();
        individualRepositoryMock = mock(IndividualJpaRepositoryImpl.class);
        userRepositoryMock = mock(UserJpaRepositoryImpl.class);
        service = new IndividualServiceImpl(individualRepositoryMock, userRepositoryMock);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Individual> individuals = Arrays.asList(new Individual(), new Individual());
        when(individualRepositoryMock.getAll()).thenReturn(individuals);
        List<Individual> all = service.getAll();
        verify(individualRepositoryMock).getAll();
        assertNotNull(all);
        assertTrue(all.size() == 2);
    }

    @Test
    public void testGetWithAllProperties() throws Exception {
        int id = 1;
        when(individualRepositoryMock.getWithAllProperties(id)).thenReturn(individual);
        Individual withAllProperties = service.getWithAllProperties(id);
        verify(individualRepositoryMock, only()).getWithAllProperties(id);
        assertNotNull(withAllProperties);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testGetWithAllPropertiesException() throws Exception {
        int id = 1;
        when(individualRepositoryMock.getWithAllProperties(id)).thenReturn(null);
        service.getWithAllProperties(id);
    }

    @Test
    public void testUpdateWithoutRelations() throws Exception {
        int id = 1;
        when(individualRepositoryMock.updateWithoutRelations(individual, id)).thenReturn(individual);
        service.updateWithoutRelations(individual, id);
        verify(individualRepositoryMock, only()).updateWithoutRelations(individual, id);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testUpdateWithoutRelationsException() throws Exception {
        int id = 1;
        when(individualRepositoryMock.updateWithoutRelations(individual, id)).thenReturn(null);
        service.updateWithoutRelations(individual, id);
    }

    @Test
    public void testDelete() throws Exception {
        when(individualRepositoryMock.delete(anyInt())).thenReturn(true);
        service.delete(1);
        verify(individualRepositoryMock).delete(anyInt());
    }

    @Test(expected = EntryNotFoundException.class)
    public void testDeleteException() throws Exception {
        when(individualRepositoryMock.delete(anyInt())).thenReturn(false);
        service.delete(1);
    }
}