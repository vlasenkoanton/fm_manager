package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.service.EntrepreneurService;
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
public class EntrepreneurInfoControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private EntrepreneurService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testEditEntrepreneur() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        EntrepreneurInfo entrepreneurInfo = INDIVIDUAL_1.getEntrepreneurInfo();

        when(serviceMock.getByOwner(ownerId)).thenReturn(entrepreneurInfo);

        mockMvc.perform(get("/profiles/individuals/{id}/entrepreneur", ownerId))
                .andExpect(status().isOk())
                .andExpect(view().name("entrepreneurInfo"))
                .andExpect(forwardedUrl("/WEB-INF/views/entrepreneurInfo.jsp"))
                .andExpect(model().attribute("entrepreneurInfo", entrepreneurInfo));

        verify(serviceMock, only()).getByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testNewEntrepreneur() throws Exception {
        when(serviceMock.getByOwner(anyInt())).thenReturn(null);

        mockMvc.perform(get("/profiles/individuals/{id}/entrepreneur", anyInt()))
                .andExpect(status().isOk())
                .andExpect(view().name("entrepreneurInfo"))
                .andExpect(forwardedUrl("/WEB-INF/views/entrepreneurInfo.jsp"))
                .andExpect(model().attribute("entrepreneurInfo", instanceOf(EntrepreneurInfo.class)));

        verify(serviceMock, only()).getByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveEntrepreneur() throws Exception {
        int ownerId = 2;
        int id = 1;
        int regNumber = 12534;
        EntrepreneurInfo expected = new EntrepreneurInfo();
        expected.setId(id);
        expected.setRegNumber(regNumber);

        mockMvc.perform(post("/profiles/individuals/{id}/entrepreneur", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("regNumber", String.valueOf(regNumber))
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        ArgumentCaptor<EntrepreneurInfo> captor = ArgumentCaptor.forClass(EntrepreneurInfo.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        EntrepreneurInfo actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveEntrepreneurNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/entrepreneur", 1)
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
    public void testDeleteEntrepreneur() throws Exception {
        int ownerId = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/entrepreneur", ownerId)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        verify(serviceMock, only()).deleteByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteEntrepreneurNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/entrepreneur", anyInt())
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