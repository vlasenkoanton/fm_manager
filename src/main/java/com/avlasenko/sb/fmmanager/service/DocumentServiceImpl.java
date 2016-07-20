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
    public void save(Document document, int ownerId) {
        ExceptionUtil.checkNotFoundByClient(repository.save(document, ownerId), ownerId);
    }

    @Override
    public Document get(int id, int ownerId) {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, ownerId), ownerId);
    }

    @Override
    @Transactional
    public void delete(int id, int ownerId) {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, ownerId), ownerId);
    }
}
