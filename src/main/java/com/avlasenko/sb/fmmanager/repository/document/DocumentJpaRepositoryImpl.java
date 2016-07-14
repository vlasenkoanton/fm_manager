package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class DocumentJpaRepositoryImpl extends GenericJpaRepository<Document> implements DocumentJpaRepository {
    public DocumentJpaRepositoryImpl() {
        super(Document.class);
    }


    @Override
    public Document save(Document document, int clientId) {
        if (!document.isNew() && get(document.getId(), clientId) == null) {
            return null;
        }

        Client client = entityManager.getReference(Client.class, clientId);
        document.setClient(client);
        return save(document);
    }

    @Override
    public Document get(int id, int clientId) {
        TypedQuery<Document> query = entityManager.createNamedQuery(Document.GET_BY_CLIENT, Document.class);
        query.setParameter("id", id);
        query.setParameter("ownerId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        Query query = entityManager.createNamedQuery(Document.DELETE_BY_CLIENT);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return query.executeUpdate() == 1;
    }
}
