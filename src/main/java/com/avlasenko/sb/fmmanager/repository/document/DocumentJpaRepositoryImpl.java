package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.model.Person;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
@Repository
public class DocumentJpaRepositoryImpl extends GenericJpaRepository<Document> implements DocumentJpaRepository {
    public DocumentJpaRepositoryImpl() {
        super(Document.class);
    }


    @Override
    public Document save(Document document, int ownerId) {
        Client client = entityManager.getReference(Client.class, ownerId);
        document.setOwner(client);
        return save(document);
    }

    @Override
    public Document getByOwner(int id, int ownerId) {
        TypedQuery<Document> query = entityManager.createNamedQuery(Document.GET_BY_OWNER, Document.class);
        query.setParameter("id", id);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }
}
