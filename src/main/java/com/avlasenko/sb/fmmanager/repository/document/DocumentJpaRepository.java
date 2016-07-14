package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
public interface DocumentJpaRepository extends GenericBaseRepository<Document> {
    Document save(Document document, int clientId);

    Document get(int id, int clientId);

    boolean delete(int id, int clientId);
}
