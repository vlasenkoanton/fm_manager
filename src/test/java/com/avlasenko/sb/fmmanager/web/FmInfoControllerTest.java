package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.service.FmInfoService;
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
public class FmInfoControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private FmInfoService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testEditFmInfo() throws Exception {
        int owerId = INDIVIDUAL_1.getId();
        FmInfo fmInfo = INDIVIDUAL_1.getFmInfo();

        when(serviceMock.getByOwner(owerId)).thenReturn(fmInfo);

        mockMvc.perform(get("/profiles/individuals/{id}/fmInfo", owerId))
                .andExpect(status().isOk())
                .andExpect(view().name("fmInfo"))
                .andExpect(forwardedUrl("/WEB-INF/views/fmInfo.jsp"));

        verify(serviceMock, only()).getByOwner(owerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testNewFmInfo() throws Exception {
        when(serviceMock.getByOwner(anyInt())).thenReturn(null);

        mockMvc.perform(get("/profiles/individuals/{id}/fmInfo", anyInt()))
                .andExpect(status().isOk())
                .andExpect(view().name("fmInfo"))
                .andExpect(forwardedUrl("/WEB-INF/views/fmInfo.jsp"));

        verify(serviceMock, only()).getByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveFmInfo() throws Exception {
        int ownerId = 2;
        int id = 1;
        String serviceHistory = "serviceHistory";
        FmInfo expected = new FmInfo();
        expected.setId(id);
        expected.setServiceHistory(serviceHistory);

        mockMvc.perform(post("/profiles/individuals/{id}/fmInfo", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("serviceHistory", serviceHistory)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        ArgumentCaptor<FmInfo> captor = ArgumentCaptor.forClass(FmInfo.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        FmInfo actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveFmInfoNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/fmInfo", 1)
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
    public void testDeleteFmInfo() throws Exception {
        int ownerId = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/fmInfo", ownerId)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        verify(serviceMock, only()).deleteByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteFmInfoNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/fmInfo", anyInt())
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