package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.WebTestData;
import com.avlasenko.sb.fmmanager.service.IndividualService;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by A. Vlasenko on 19.08.2016.
 */
public class IndividualProxyControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private IndividualService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testCreateProxy() throws Exception {
        mockMvc.perform(get("/profiles/individuals/{id}/proxies/{type}", 1, "accOpener"))
                .andExpect(status().isOk())
                .andExpect(view().name("individualQuickForm"))
                .andExpect(forwardedUrl("/WEB-INF/views/individualQuickForm.jsp"))
                .andExpect(model().attribute("individual", instanceOf(IndividualQuickFormDTO.class)));
    }

    @Test
    public void testSaveProxy() throws Exception {
        int id = 1;
        String type = "type";

        mockMvc.perform(post("/profiles/individuals/{id}/proxies/{type}", id, type)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(WebTestData.NEW_CLIENT_PARAMS)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+id))
                .andExpect(redirectedUrl("/profiles/individuals/"+id));

        verify(serviceMock, only()).saveProxy(any(), eq(id), eq(type));
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveProxyNotFound() throws Exception {
        int id = 1;
        String type = "type";

        doThrow(EntryNotFoundException.class).when(serviceMock).saveProxy(any(), anyInt(), anyString());

        mockMvc.perform(post("/profiles/individuals/{id}/proxies/{type}", id, type)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(WebTestData.NEW_CLIENT_PARAMS)
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).saveProxy(any(), eq(id), eq(type));
        verifyNoMoreInteractions(serviceMock);
    }
}