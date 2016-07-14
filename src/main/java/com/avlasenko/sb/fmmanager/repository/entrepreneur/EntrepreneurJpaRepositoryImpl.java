package com.avlasenko.sb.fmmanager.repository.entrepreneur;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class EntrepreneurJpaRepositoryImpl extends GenericJpaRepository<EntrepreneurInfo> implements EntrepreneurJpaRepository {
    public EntrepreneurJpaRepositoryImpl() {
        super(EntrepreneurInfo.class);
    }

    @Override
    public EntrepreneurInfo save(EntrepreneurInfo entrepreneurInfo, int clientId) {
        if (!entrepreneurInfo.isNew() && get(entrepreneurInfo.getId(), clientId) == null) {
            return null;
        }

        if (entrepreneurInfo.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            client.setEntrepreneurInfo(entrepreneurInfo);
            entityManager.merge(client);
            return entrepreneurInfo;
        } else {
            return save(entrepreneurInfo);
        }
    }

    @Override
    public EntrepreneurInfo get(int id, int clientId) {
        TypedQuery<EntrepreneurInfo> query =
                entityManager.createNamedQuery(EntrepreneurInfo.GET_BY_CLIENT, EntrepreneurInfo.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        if (get(id, clientId) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(EntrepreneurInfo.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
