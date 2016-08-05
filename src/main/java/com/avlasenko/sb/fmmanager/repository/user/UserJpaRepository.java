package com.avlasenko.sb.fmmanager.repository.user;

import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 27.07.2016.
 */
@Transactional
public interface UserJpaRepository extends GenericBaseRepository<User> {

    User getByLogin(String login);
}
