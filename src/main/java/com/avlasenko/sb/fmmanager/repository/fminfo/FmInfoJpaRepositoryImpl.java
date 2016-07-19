package com.avlasenko.sb.fmmanager.repository.fminfo;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class FmInfoJpaRepositoryImpl extends GenericJpaRepository<FmInfo> implements FmInfoJpaRepository {
    public FmInfoJpaRepositoryImpl() {
        super(FmInfo.class);
    }

    @Override
    public FmInfo save(FmInfo fmInfo, int clientId) {
        if (!fmInfo.isNew() && get(fmInfo.getId(), clientId) == null) {
            return null;
        }

        if (fmInfo.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            client.setFmInfo(fmInfo);
            entityManager.merge(client);
            return fmInfo;
        } else {
            return save(fmInfo);
        }
    }

    @Override
    public FmInfo get(int id, int clientId) {
        TypedQuery<FmInfo> query = entityManager.createNamedQuery(FmInfo.GET_BY_CLIENT, FmInfo.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        if (get(id, clientId) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(FmInfo.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
