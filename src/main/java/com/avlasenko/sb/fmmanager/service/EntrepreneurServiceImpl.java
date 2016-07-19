package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.entrepreneur.EntrepreneurJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Service
public class EntrepreneurServiceImpl implements EntrepreneurService {

    @Autowired
    private EntrepreneurJpaRepository repository;

    @Override
    @Transactional
    public void save(EntrepreneurInfo entrepreneurInfo, int clientId) {
        ExceptionUtil.checkNotFoundByClient(repository.save(entrepreneurInfo, clientId), clientId);
    }

    @Override
    public EntrepreneurInfo get(int id, int clientId) {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, clientId), clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, clientId), clientId);
    }
}
