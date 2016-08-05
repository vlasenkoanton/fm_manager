package com.avlasenko.sb.fmmanager.repository.user;

import com.avlasenko.sb.fmmanager.model.User;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 27.07.2016.
 */
@Repository
public class UserJpaRepositoryImpl extends GenericJpaRepository<User> implements UserJpaRepository {
    public UserJpaRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User getByLogin(String login) {
        TypedQuery<User> query = entityManager.createNamedQuery(User.GET_BY_LOGIN, User.class);
        query.setParameter("login", login);
        return DataAccessUtils.singleResult(query.getResultList());
    }
}
