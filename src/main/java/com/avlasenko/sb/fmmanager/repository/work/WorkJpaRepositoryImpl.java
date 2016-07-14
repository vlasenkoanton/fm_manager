package com.avlasenko.sb.fmmanager.repository.work;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Work;
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
public class WorkJpaRepositoryImpl extends GenericJpaRepository<Work> implements WorkJpaRepository {

    public WorkJpaRepositoryImpl() {
        super(Work.class);
    }

    @Override
    public Work save(Work work, int clientId) {
        if (!work.isNew() && get(work.getId(), clientId) == null) {
            return null;
        }

        if (work.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            client.setWork(work);
            entityManager.merge(client);
            return work;
        } else {
            return save(work);
        }
    }

    @Override
    public Work get(int id, int clientId) {
        TypedQuery<Work> query = entityManager.createNamedQuery(Work.GET_BY_CLIENT, Work.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        if (get(id, clientId) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(Work.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
