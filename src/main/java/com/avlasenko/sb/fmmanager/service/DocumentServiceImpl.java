package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
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
    public void saveByOwner(Document document, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.saveByOwner(document, ownerId), ownerId);
    }

    @Override
    public Document getByOwner(int id, int ownerId) {
        return ExceptionUtil.checkNotFoundByOwner(repository.getByOwner(id, ownerId), ownerId);
    }

    @Override
    @Transactional
    public void deleteByOwner(int id, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.deleteByOwner(id, ownerId), ownerId);
    }
}
