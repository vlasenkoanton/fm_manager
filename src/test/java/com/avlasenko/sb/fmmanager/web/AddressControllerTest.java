package com.avlasenko.sb.fmmanager.web;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.service.AddressService;
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
 * Created by A. Vlasenko on 11.08.2016.
 */
public class AddressControllerTest extends AbstractControllerTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private AddressService serviceMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        reset(serviceMock);
    }

    @Test
    public void testEditAddress() throws Exception {
        int ownerId = INDIVIDUAL_1.getId();
        Address address = INDIVIDUAL_1.getAddress();

        when(serviceMock.getByOwner(ownerId)).thenReturn(address);

        mockMvc.perform(get("/profiles/individuals/{id}/address", ownerId))
                .andExpect(status().isOk())
                .andExpect(view().name("address"))
                .andExpect(forwardedUrl("/WEB-INF/views/address.jsp"))
                .andExpect(model().attribute("address", address));

        verify(serviceMock, only()).getByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testNewAddress() throws Exception {
        when(serviceMock.getByOwner(anyInt())).thenReturn(null);

        mockMvc.perform(get("/profiles/individuals/{id}/address", anyInt()))
                .andExpect(status().isOk())
                .andExpect(view().name("address"))
                .andExpect(forwardedUrl("/WEB-INF/views/address.jsp"))
                .andExpect(model().attribute("address", instanceOf(Address.class)));

        verify(serviceMock, only()).getByOwner(anyInt());
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testSaveAddress() throws Exception {
        int ownerId = 2;
        int id = 1;
        String city = "city";
        Address expected = new Address();
        expected.setId(id);
        expected.setCity(city);

        mockMvc.perform(post("/profiles/individuals/{id}/address", ownerId)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", String.valueOf(id))
                .param("city", city)
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        ArgumentCaptor<Address> captor = ArgumentCaptor.forClass(Address.class);
        verify(serviceMock, only()).saveByOwner(captor.capture(), eq(ownerId));
        verifyNoMoreInteractions(serviceMock);

        Address actual = captor.getValue();
        assertEntityEquals(expected, actual);
    }

    @Test
    public void testSaveAddressNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).saveByOwner(any(), anyInt());

        mockMvc.perform(post("/profiles/individuals/{id}/address", 1)
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
    public void testDeleteAddress() throws Exception {
        int ownerId = 1;

        mockMvc.perform(get("/profiles/individuals/{id}/address", ownerId)
                .param("action", "delete")
        )
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/profiles/individuals/" + ownerId))
                .andExpect(redirectedUrl("/profiles/individuals/" + ownerId));

        verify(serviceMock, only()).deleteByOwner(ownerId);
        verifyNoMoreInteractions(serviceMock);
    }

    @Test
    public void testDeleteAddressNotFound() throws Exception {
        doThrow(EntryNotFoundException.class).when(serviceMock).deleteByOwner(anyInt());

        mockMvc.perform(get("/profiles/individuals/{id}/address", anyInt())
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