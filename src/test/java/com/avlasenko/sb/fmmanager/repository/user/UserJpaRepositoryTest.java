package com.avlasenko.sb.fmmanager.repository.user;

import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.repository.AbstractJpaRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.avlasenko.sb.fmmanager.TestData.*;
import static com.avlasenko.sb.fmmanager.util.TestUtils.*;
import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */
public class UserJpaRepositoryTest extends AbstractJpaRepositoryTest {

    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    @Autowired
    private UserJpaRepository repository;

    @Test
    public void testGetByLogin() throws Exception {
        User byLogin = repository.getByLogin(USER_1.getLogin());
        assertEntityEquals(USER_1, byLogin);
    }

    @Test
    public void testGetByLoginNull() throws Exception {
        assertNull(repository.getByLogin("nonexistent"));
    }
}