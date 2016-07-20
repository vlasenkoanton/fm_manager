package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
public interface DocumentJpaRepository extends GenericBaseRepository<Document> {
    Document save(Document document, int ownerId);

    Document get(int id, int ownerId);

    boolean delete(int id, int ownerId);
}
