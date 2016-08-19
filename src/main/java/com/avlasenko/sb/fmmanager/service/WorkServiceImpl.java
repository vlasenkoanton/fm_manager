package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.work.WorkJpaRepository;
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
    public void saveByOwner(Work work, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.saveByOwner(work, ownerId), ownerId);
    }

    @Override
    public Work getByOwner(int ownerId) {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void deleteByOwner(int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.deleteByOwner(ownerId), ownerId);
    }
}
