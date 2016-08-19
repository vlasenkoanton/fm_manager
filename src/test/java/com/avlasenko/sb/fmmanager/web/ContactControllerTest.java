package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.service.ContactService;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
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
public class ContactControllerTest extends AbstractControllerTest{

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private ContactService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testEditContact() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Contact contact = INDIVIDUAL_1.getContact();

        when(serviceMock.getByOwner(ownerId)).thenReturn(contact);

        mockMvc.perform(get("/profiles/individuals/{id}/contact", ownerId))
                .andExpect(status().isOk())
                .andExpect(view().name("contact"))
                .andExpect(forwardedUrl("/WEB-INF/views/contact.jsp"))
                .andExpect(model().attribute("contact", contact));

        verify(serviceMock, only()).getByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testNewContact() throws Exception {
        when(serviceMock.getByOwner(anyInt())).thenReturn(null);

        mockMvc.perform(get("/profiles/individuals/{id}/contact", anyInt()))
                .andExpect(status().isOk())
                .andExpect(view().name("contact"))
                .andExpect(forwardedUrl("/WEB-INF/views/contact.jsp"))
                .andExpect(model().attribute("contact", instanceOf(Contact.class)));

        verify(serviceMock, only()).getByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveContact() throws Exception {
        int ownerId = 2;
        int id = 1;
        String mob = "45698521";
        Contact expected = new Contact();
        expected.setId(id);
        expected.setMobileTel(mob);

        mockMvc.perform(post("/profiles/individuals/{id}/contact", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("mobileTel", mob)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        ArgumentCaptor<Contact> captor = ArgumentCaptor.forClass(Contact.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        Contact actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveContactNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/contact", 1)
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
    public void testDeleteContact() throws Exception {
        int ownerId = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/contact", ownerId)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        verify(serviceMock, only()).deleteByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteContactNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/contact", anyInt())
                .param("action", "delete")
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).deleteByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }
}