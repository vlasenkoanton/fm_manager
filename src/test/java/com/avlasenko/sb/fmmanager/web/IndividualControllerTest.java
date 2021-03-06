package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.service.IndividualService;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import com.avlasenko.sb.fmmanager.util.dto.converter.DTOConverter;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.WebTestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class IndividualControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private IndividualService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testGetAll() throws Exception {
        when(serviceMock.getAll()).thenReturn((List<Individual>) ALL_INDIVIDUALS);

        mockMvc.perform(get("/profiles/individuals"))
                .andExpect(status().isOk())
                .andExpect(view().name("individuals"))
                .andExpect(forwardedUrl("/WEB-INF/views/individuals.jsp"))
                .andExpect(model().attribute("individuals", hasSize(ALL_INDIVIDUALS.size())))
                .andExpect(model().attribute("individuals", ALL_INDIVIDUALS));

        verify(serviceMock, only()).getAll();
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testEditIndividual() throws Exception {
        when(serviceMock.getWithAllProperties(INDIVIDUAL_1.getId())).thenReturn(INDIVIDUAL_1);

        mockMvc.perform(get("/profiles/individuals/{id}", INDIVIDUAL_1.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("client"))
                .andExpect(forwardedUrl("/WEB-INF/views/client.jsp"))
                .andExpect(model().attribute("individual", INDIVIDUAL_1));

        verify(serviceMock, only()).getWithAllProperties(INDIVIDUAL_1.getId());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testEditIndividualNotFound() throws Exception {
        when(serviceMock.getWithAllProperties(anyInt())).thenThrow(new EntryNotFoundException(""));

        mockMvc.perform(get("/profiles/individuals/{id}", anyInt()))
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).getWithAllProperties(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveIndividual() throws Exception {
        Integer id = VALID_INDIVIDUAL.getId();

        mockMvc.perform(post("/profiles/individuals/{id}", id)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(VALID_INDIVIDUAL_PARAMS)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals"))
                .andExpect(redirectedUrl("/profiles/individuals"));

        ArgumentCaptor<Individual> captor = ArgumentCaptor.forClass(Individual.class);
        verify(serviceMock, only()).updateWithoutRelations(captor.capture(), eq(id));
        verifyNoMoreInteractions(serviceMock);

        Individual actual = captor.getValue();
        assertEntityEquals(VALID_INDIVIDUAL, actual);
    }

    @Test
    public void testSaveIndividualNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).updateWithoutRelations(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}", 2)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .params(VALID_INDIVIDUAL_PARAMS)
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).updateWithoutRelations(any(), anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testCreateClient() throws Exception {
        mockMvc.perform(get("/profiles/individuals")
                .param("action", "create")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("individualQuickForm"))
                .andExpect(forwardedUrl("/WEB-INF/views/individualQuickForm.jsp"))
                .andExpect(model().attribute("individual", instanceOf(IndividualQuickFormDTO.class)));
    }

    @Test
    public void testSaveNewClient() throws Exception {
        int id = 1;
        Individual expected = DTOConverter.convertToEntity(DTO);

        when(serviceMock.saveClient(any())).thenReturn(id);

        mockMvc.perform(post("/profiles/individuals")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("action", "create")
                .params(NEW_CLIENT_PARAMS)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/"+id))
                .andExpect(redirectedUrl("/profiles/individuals/"+id));

        ArgumentCaptor<Individual> captor = ArgumentCaptor.forClass(Individual.class);
        verify(serviceMock, only()).saveClient(captor.capture());
        verifyNoMoreInteractions(serviceMock);

        Individual actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testDeleteIndividual() throws Exception {
        int id = 1;

        mockMvc.perform(get("/profiles/individuals/{id}", id)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals"))
                .andExpect(redirectedUrl("/profiles/individuals"));

        verify(serviceMock, only()).delete(id);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteIndividualNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).delete(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}", anyInt())
                .param("action", "delete")
        )
                .andExpect(status().isNotFound())
                .andExpect(view().name("errors/notFound"))
                .andExpect(forwardedUrl("/WEB-INF/views/errors/notFound.jsp"))
                .andExpect(model().attribute("exception", instanceOf(EntryNotFoundException.class)));

        verify(serviceMock, only()).delete(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }
}