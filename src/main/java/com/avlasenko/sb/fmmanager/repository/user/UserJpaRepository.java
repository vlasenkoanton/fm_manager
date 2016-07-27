package com.avlasenko.sb.fmmanager.repository.user;

import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 27.07.2016.
 */
public interface UserJpaRepository extends GenericBaseRepository<User> {

    User getByLogin(String login);
}
