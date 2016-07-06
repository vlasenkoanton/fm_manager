package com.avlasenko.sb.fmmanager.repository.client;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 15.06.2016.
 */
@Repository
public class ClientJpaRepositoryImpl extends GenericJpaRepository<Client> implements ClientJpaRepository {

    public ClientJpaRepositoryImpl() {
        super(Client.class);
    }

    @Override
    public Client getWithAllProperties(int id) {
        TypedQuery<Client> query = entityManager.createNamedQuery(Client.GET_WITH_PROPERTIES, Client.class);
        query.setParameter("id", id);
        return DataAccessUtils.singleResult(query.getResultList());
    }
}
