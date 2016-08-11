package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.fminfo.FmInfoJpaRepository;
import com.avlasenko.sb.fmmanager.repository.fminfo.FmInfoJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class FmInfoServiceTest {

    private FmInfoService service;
    private FmInfoJpaRepository repositoryMock;

    @Before
    public void setUp() throws Exception {
        service = new FmInfoServiceImpl();
        repositoryMock = mock(FmInfoJpaRepositoryImpl.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testSaveByOwner() throws Exception {
        FmInfo fmInfo = new FmInfo();
        int ownerId = 1;
        when(repositoryMock.saveByOwner(fmInfo, ownerId)).thenReturn(fmInfo);
        service.saveByOwner(fmInfo, ownerId);
        verify(repositoryMock, only()).saveByOwner(fmInfo, ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveByOwnerException() throws Exception {
        when(repositoryMock.saveByOwner(any(), anyInt())).thenReturn(null);
        service.saveByOwner(any(), anyInt());
    }

    @Test
    public void testGetByOwner() throws Exception {
        FmInfo fmInfo = new FmInfo();
        int ownerId = 1;
        when(repositoryMock.getByOwner(ownerId)).thenReturn(fmInfo);
        service.getByOwner(ownerId);
        verify(repositoryMock, only()).getByOwner(ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testGetByOwnerException() throws Exception {
        when(repositoryMock.getByOwner(anyInt())).thenReturn(null);
        service.getByOwner(anyInt());
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