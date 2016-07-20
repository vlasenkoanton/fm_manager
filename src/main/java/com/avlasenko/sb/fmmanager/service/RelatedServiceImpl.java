package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Related;
import com.avlasenko.sb.fmmanager.repository.related.RelatedJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Service
public class RelatedServiceImpl implements RelatedService {

    @Autowired
    private RelatedJpaRepository repository;

    @Override
    @Transactional
    public void save(Related related, int clientId, String type) throws EntityNotFoundException {
        ExceptionUtil.checkNotFoundByClient(repository.save(related, clientId, type), clientId);
    }

    @Override
    public Related get(int id, int clientId, String type) throws EntityNotFoundException {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, clientId, type), clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId, String type) throws EntityNotFoundException {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, clientId, type), clientId);
    }
}
