package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.entrepreneur.EntrepreneurJpaRepository;
import com.avlasenko.sb.fmmanager.repository.entrepreneur.EntrepreneurJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class EntrepreneurServiceTest {

    private EntrepreneurService service;
    private EntrepreneurJpaRepository repositoryMock;

    @Before
    public void setUp() throws Exception {
        service = new EntrepreneurServiceImpl();
        repositoryMock = mock(EntrepreneurJpaRepositoryImpl.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testSaveByOwner() throws Exception {
        EntrepreneurInfo entrepreneurInfo = new EntrepreneurInfo();
        int ownerId = 1;
        when(repositoryMock.saveByOwner(entrepreneurInfo, ownerId)).thenReturn(entrepreneurInfo);
        service.saveByOwner(entrepreneurInfo, ownerId);
        verify(repositoryMock, only()).saveByOwner(entrepreneurInfo, ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveByOwnerException() throws Exception {
        when(repositoryMock.saveByOwner(any(), anyInt())).thenReturn(null);
        service.saveByOwner(any(), anyInt());
    }

    @Test
    public void testGetByOwner() throws Exception {
        EntrepreneurInfo entrepreneurInfo = new EntrepreneurInfo();
        int ownerId = 1;
        when(repositoryMock.getByOwner(ownerId)).thenReturn(entrepreneurInfo);
        service.getByOwner(ownerId);
        verify(repositoryMock, only()).getByOwner(ownerId);
    }

    @Test
    public void testDeleteByOwner() throws Exception {
        when(repositoryMock.deleteByOwner(anyInt())).thenReturn(true);
        service.deleteByOwner(anyInt());
        verify(repositoryMock, only()).deleteByOwner(anyInt());
    }

    @Test(expected = EntryNotFoundException.class)
    public void testDeleteByOwnerException() throws Exception {
        when(repositoryMock.deleteByOwner(anyInt())).thenReturn(false);
        service.deleteByOwner(anyInt());
    }
}