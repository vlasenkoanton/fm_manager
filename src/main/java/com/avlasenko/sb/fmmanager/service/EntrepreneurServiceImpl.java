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
    public void saveByOwner(EntrepreneurInfo entrepreneurInfo, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.saveByOwner(entrepreneurInfo, ownerId), ownerId);
    }

    @Override
    public EntrepreneurInfo getByOwner(int ownerId) {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void deleteByOwner(int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.deleteByOwner(ownerId), ownerId);
    }
}
