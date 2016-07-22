package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.work.WorkJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
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
    public void save(Work work, int ownerId) throws EntryNotFoundException {
        repository.save(work, ownerId);
    }

    @Override
    public Work getByOwner(int ownerId) throws EntryNotFoundException {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void delete(int ownerId) throws EntryNotFoundException {
        repository.delete(ownerId);
    }
}
