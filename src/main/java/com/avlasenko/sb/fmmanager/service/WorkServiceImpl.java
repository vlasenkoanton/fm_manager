package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.work.WorkJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private WorkJpaRepository repository;

    @Override
    @Transactional
    public void save(Work work, int clientId) {
        repository.save(work, clientId);
    }

    @Override
    public Work get(int id, int clientId) {
        return repository.get(id, clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        repository.delete(id, clientId);
    }
}
