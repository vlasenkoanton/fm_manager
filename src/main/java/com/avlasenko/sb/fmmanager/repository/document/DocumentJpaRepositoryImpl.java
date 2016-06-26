package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
@Repository
public class DocumentJpaRepositoryImpl extends GenericJpaRepository<Document> implements DocumentJpaRepository {
    public DocumentJpaRepositoryImpl() {
        super(Document.class);
    }

    @Override
    public Document get(int id, int ownerId) {
        Query query = entityManager.createQuery("select d from Document d where d.id=:id and d.ownerId=:ownerId");
        query.setParameter("id", id);
        query.setParameter("ownerId", ownerId);

        return (Document) query.getSingleResult();
    }
}
