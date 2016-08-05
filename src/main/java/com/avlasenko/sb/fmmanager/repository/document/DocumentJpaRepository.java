package com.avlasenko.sb.fmmanager.repository.document;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
@Transactional
public interface DocumentJpaRepository extends GenericBaseRepository<Document> {
    Document saveByOwner(Document document, int ownerId);

    Document getByOwner(int id, int ownerId);

    boolean deleteByOwner(int id, int ownerId);
}
