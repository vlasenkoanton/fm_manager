package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.model.UserRole;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepository;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by A. Vlasenko on 11.08.2016.
 */
public class UserServiceTest {

    private UserService service;
    private UserJpaRepository repositoryMock;

    @Before
    public void setUp() throws Exception {
        service = new UserServiceImpl();
        repositoryMock = mock(UserJpaRepositoryImpl.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }

    @Test
    public void testLoadUserByUsername() throws Exception {
        User user = new User(1, "login", "password", "firstName", "lastName", "middleName", "1524", "manager",
                new HashSet<>(Arrays.asList(UserRole.ROLE_USER)));
        String userName = user.getLogin();

        when(repositoryMock.getByLogin(userName)).thenReturn(user);
        UserDetails userDetails = ((UserDetailsService) service).loadUserByUsername(userName);
        assertEquals(userName, userDetails.getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameException() throws Exception {
        when(repositoryMock.getByLogin(anyString())).thenReturn(null);
        ((UserDetailsService) service).loadUserByUsername(anyString());
    }
}