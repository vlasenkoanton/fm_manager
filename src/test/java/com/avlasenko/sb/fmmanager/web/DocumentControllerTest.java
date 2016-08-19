package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.service.DocumentService;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by A. Vlasenko on 19.08.2016.
 */
public class DocumentControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private DocumentService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testNewDocument() throws Exception {
        mockMvc.perform(get("/profiles/individuals/{id}/documents", 1)
                .param("action", "create")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("document"))
                .andExpect(forwardedUrl("/WEB-INF/views/document.jsp"))
                .andExpect(model().attribute("document", instanceOf(Document.class)));
    }

    @Test
    public void testSaveNewDocument() throws Exception {
        int ownerId = 2;
        int id = 1;
        String name = "name";
        Document expected = new Document();
        expected.setId(id);
        expected.setName(name);

        mockMvc.perform(post("/profiles/individuals/{id}/documents", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("action", "create")
                .param("id", String.valueOf(id))
                .param("name", name)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/"+ownerId));

        ArgumentCaptor<Document> captor = ArgumentCaptor.forClass(Document.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        Document actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveNewDocumentNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/documents", 1)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("action", "create")
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).saveByOwner(any(), anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testEditDocument() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Document document = INDIVIDUAL_1.getDocuments().stream().findFirst().orElse(new Document());

        when(serviceMock.getByOwner(document.getId(), ownerId)).thenReturn(document);

        mockMvc.perform(get("/profiles/individuals/{id}/documents/{docId}", ownerId, document.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("document"))
                .andExpect(forwardedUrl("/WEB-INF/views/document.jsp"))
                .andExpect(model().attribute("document", document));

        verify(serviceMock, only()).getByOwner(document.getId(), ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testEditDocumentNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).getByOwner(anyInt(), anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/documents/{docId}", anyInt(), anyInt()))
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).getByOwner(anyInt(), anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveDocument() throws Exception {
        int ownerId = 2;
        int id = 1;
        String name = "name";
        Document expected = new Document();
        expected.setId(id);
        expected.setName(name);

        mockMvc.perform(post("/profiles/individuals/{id}/documents/{docId}", ownerId, id)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("name", name)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/"+ownerId));

        ArgumentCaptor<Document> captor = ArgumentCaptor.forClass(Document.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        Document actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveDocumentNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/documents/{docId}", anyInt(), anyInt())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).saveByOwner(any(), anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteDocument() throws Exception {
        int ownerId = 2;
        int id = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/documents/{docId}", ownerId, id)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/"+ownerId));

        verify(serviceMock, only()).deleteByOwner(id, ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteDocumentNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt(), anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/documents/{docId}", anyInt(), anyInt())
                .param("action", "delete")
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).deleteByOwner(anyInt(), anyInt());
        verifyNoMoreInteractions(serviceMock);
    }
}