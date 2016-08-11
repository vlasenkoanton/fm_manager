package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepositoryImpl;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class DocumentServiceTest {

    private DocumentService service;
    private DocumentJpaRepository repositoryMock;

    @Before
    public void setUp() throws Exception {
        service = new DocumentServiceImpl();
        repositoryMock = mock(DocumentJpaRepositoryImpl.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testSaveByOwner() throws Exception {
        Document document = new Document();
        int ownerId = 1;
        when(repositoryMock.saveByOwner(document, ownerId)).thenReturn(document);
        service.saveByOwner(document, ownerId);
        verify(repositoryMock, only()).saveByOwner(document, ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveByOwnerException() throws Exception {
        when(repositoryMock.saveByOwner(any(), anyInt())).thenReturn(null);
        service.saveByOwner(any(), anyInt());
    }

    @Test
    public void testGetByOwner() throws Exception {
        Document document = new Document();
        document.setId(1);
        int ownerId = 1;
        when(repositoryMock.getByOwner(document.getId(), ownerId)).thenReturn(document);
        service.getByOwner(document.getId(), ownerId);
        verify(repositoryMock, only()).getByOwner(document.getId(), ownerId);
    }

    @Test(expected = EntryNotFoundException.class)
    public void testGetByOwnerException() throws Exception {
        when(repositoryMock.getByOwner(anyInt(), anyInt())).thenReturn(null);
        service.getByOwner(anyInt(), anyInt());
    }

    @Test
    public void testDeleteByOwner() throws Exception {
        when(repositoryMock.deleteByOwner(anyInt(), anyInt())).thenReturn(true);
        service.deleteByOwner(anyInt(), anyInt());
        verify(repositoryMock, only()).deleteByOwner(anyInt(), anyInt());
    }

    @Test(expected = EntryNotFoundException.class)
    public void testDeleteByOwnerException() throws Exception {
        when(repositoryMock.deleteByOwner(anyInt(), anyInt())).thenReturn(false);
        service.deleteByOwner(anyInt(), anyInt());
    }
}