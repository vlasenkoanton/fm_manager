package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentJpaRepository repository;

    @Override
    @Transactional
    public void save(Document document, int ownerId) {
        repository.save(document, ownerId);
    }

    @Override
    public Document getByOwner(int id, int ownerId) {
        return repository.getByOwner(id, ownerId);
    }
}
