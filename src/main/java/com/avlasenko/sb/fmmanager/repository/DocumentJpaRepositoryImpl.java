package com.avlasenko.sb.fmmanager.repository;

import com.avlasenko.sb.fmmanager.model.Document;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 17.06.2016.
 */
@Repository
public class DocumentJpaRepositoryImpl extends GenericJpaRepository<Document> implements DocumentJpaRepository {
    public DocumentJpaRepositoryImpl() {
        super(Document.class);
    }


}
