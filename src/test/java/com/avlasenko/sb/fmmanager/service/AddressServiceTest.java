package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class AddressServiceTest {

    private AddressJpaRepository repositoryMock;
    private AddressService service;

    @Before
    public void setUp() throws Exception {
        repositoryMock = mock(AddressJpaRepositoryImpl.class);
        service = new AddressServiceImpl();
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testSaveByOwner() throws Exception {
        Address address = new Address();
        int ownerId = 1;
        when(repositoryMock.saveByOwner(address, ownerId)).thenReturn(address);
        service.saveByOwner(address, ownerId);
        verify(repositoryMock, only()).saveByOwner(address, ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveByOwnerException() throws Exception {
        when(repositoryMock.saveByOwner(any(), anyInt())).thenReturn(null);
        service.saveByOwner(any(), anyInt());
    }

    @Test
    public void testGetByOwner() throws Exception {
        Address address = new Address();
        int ownerId = 1;
        when(repositoryMock.getByOwner(ownerId)).thenReturn(address);
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