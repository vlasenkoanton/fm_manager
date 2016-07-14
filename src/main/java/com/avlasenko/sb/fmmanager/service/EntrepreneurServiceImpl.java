package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.entrepreneur.EntrepreneurJpaRepository;
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
        repository.save(entrepreneurInfo, clientId);
    }

    @Override
    public EntrepreneurInfo get(int id, int clientId) {
        return repository.get(id, clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        repository.delete(id, clientId);
    }
}
