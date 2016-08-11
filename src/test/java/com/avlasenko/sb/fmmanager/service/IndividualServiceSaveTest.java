package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;


import static com.avlasenko.sb.fmmanager.util.TestUtils.assertEntityEquals;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 * Created by A. Vlasenko on 10.08.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SecurityContextHolder.class)
public class IndividualServiceSaveTest extends IndividualServiceTest {

    private Authentication auth = mock(Authentication.class);
    private SecurityContext context = mock(SecurityContextImpl.class);

    private User user;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        user = new User();
        user.setId(1);
        user.setLastName("user");

        // Stubbing of getting authenticated user logic. See IndividualServiceImpl.setResponsible()
        PowerMockito.mockStatic(SecurityContextHolder.class);
        when(userRepositoryMock.getByLogin(anyString())).thenReturn(user);
        when(SecurityContextHolder.getContext()).thenReturn(context);
        when(context.getAuthentication()).thenReturn(auth);
    }

    @Test
    public void testSaveClient() throws Exception {
        //Stubbing of repository logic
        when(individualRepositoryMock.save(individual)).then((Answer<Individual>) invocation -> {
            individual.setId(1);
            return individual;
        });

        Integer id = service.saveClient(individual);

        verify(individualRepositoryMock, only()).save(any());
        assertNotNull(id);

        assertTrue("Method service.saveClient() have to set \"client\" property of Individual entity to \"true\".",
                individual.isClient());
        assertEntityEquals(user, individual.getResponsible());
        assertNotNull("Method service.saveClient() have to set \"client\" property of Individual entity to " +
                "\"current date(LocalDate.now())\"", individual.getInitialProfileFill());
    }

    @Test
    public void testSaveProxy() throws Exception {
        Individual owner = new Individual();
        owner.setId(1);
        //Stubbing of repository logic
        when(individualRepositoryMock.saveAccOpener(individual, owner.getId())).then((Answer<Individual>) invocation -> {
            individual.setId(2);
            return individual;
        });

        service.saveProxy(individual, owner.getId(), "accOpener");

        verify(individualRepositoryMock, only()).saveAccOpener(any(), anyInt());
        assertNotNull(individual.getId());

        assertFalse("Method service.saveClient() have to set \"client\" property of Individual entity to \"false\".",
                individual.isClient());
        assertEntityEquals(user, individual.getResponsible());
        assertNotNull("Method service.saveClient() have to set \"client\" property of Individual entity to " +
                "\"current date(LocalDate.now())\"", individual.getInitialProfileFill());
    }

    @Test(expected = EntryNotFoundException.class)
    public void testSaveProxyEntryNotFound() throws Exception {
        Individual owner = new Individual();
        owner.setId(1);
        //Stubbing of repository logic
        when(individualRepositoryMock.saveAccOpener(individual, owner.getId())).thenReturn(null);

        service.saveProxy(individual, owner.getId(), "accOpener");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveProxyIllegalArgument() throws Exception {
        Individual owner = new Individual();
        owner.setId(1);
        //Stubbing of repository logic
        when(individualRepositoryMock.saveAccOpener(individual, owner.getId())).then((Answer<Individual>) invocation -> {
            individual.setId(2);
            return individual;
        });

        service.saveProxy(individual, owner.getId(), "wrongType");
    }
}