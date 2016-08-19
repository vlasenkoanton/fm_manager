package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.service.WorkService;
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
public class WorkControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private WorkService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testEditWork() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Work work = INDIVIDUAL_1.getWork();

        when(serviceMock.getByOwner(ownerId)).thenReturn(work);

        mockMvc.perform(get("/profiles/individuals/{id}/work", ownerId))
                .andExpect(status().isOk())
                .andExpect(view().name("work"))
                .andExpect(forwardedUrl("/WEB-INF/views/work.jsp"))
                .andExpect(model().attribute("work", work));

        verify(serviceMock, only()).getByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testNewWork() throws Exception {
        when(serviceMock.getByOwner(anyInt())).thenReturn(null);

        mockMvc.perform(get("/profiles/individuals/{id}/work", anyInt()))
                .andExpect(status().isOk())
                .andExpect(view().name("work"))
                .andExpect(forwardedUrl("/WEB-INF/views/work.jsp"))
                .andExpect(model().attribute("work", instanceOf(Work.class)));

        verify(serviceMock, only()).getByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveWork() throws Exception {
        int ownerId = 2;
        int id = 1;
        String name = "name";
        Work expected = new Work();
        expected.setId(id);
        expected.setName(name);

        mockMvc.perform(post("/profiles/individuals/{id}/work", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("name", name)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/"+ownerId));

        ArgumentCaptor<Work> captor = ArgumentCaptor.forClass(Work.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        Work actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveWorkNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/work", 1)
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
    public void testDeleteWork() throws Exception {
        int ownerId = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/work", ownerId)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/"+ownerId));

        verify(serviceMock, only()).deleteByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteWorkNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/work", anyInt())
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