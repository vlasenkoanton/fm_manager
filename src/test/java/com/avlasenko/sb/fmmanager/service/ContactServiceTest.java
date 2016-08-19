package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.contact.ContactJpaRepository;
import com.avlasenko.sb.fmmanager.repository.contact.ContactJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class ContactServiceTest {

    private ContactService service;
    private ContactJpaRepository repositoryMock;

    @Before
    public void setUp() throws Exception {
        service = new ContactServiceImpl();
        repositoryMock = mock(ContactJpaRepositoryImpl.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testSaveByOwner() throws Exception {
        Contact contact = new Contact();
        int ownerId = 1;
        when(repositoryMock.saveByOwner(contact, ownerId)).thenReturn(contact);
        service.saveByOwner(contact, ownerId);
        verify(repositoryMock, only()).saveByOwner(contact, ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveByOwnerException() throws Exception {
        when(repositoryMock.saveByOwner(any(), anyInt())).thenReturn(null);
        service.saveByOwner(any(), anyInt());
    }

    @Test
    public void testGetByOwner() throws Exception {
        Contact contact = new Contact();
        int ownerId = 1;
        when(repositoryMock.getByOwner(ownerId)).thenReturn(contact);
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