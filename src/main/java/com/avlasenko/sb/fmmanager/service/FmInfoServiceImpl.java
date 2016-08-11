package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.fminfo.FmInfoJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Service
public class FmInfoServiceImpl implements FmInfoService {

    @Autowired
    private FmInfoJpaRepository repository;

    @Override
    @Transactional
    public void saveByOwner(FmInfo fmInfo, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.saveByOwner(fmInfo, ownerId), ownerId);
    }

    @Override
    public FmInfo getByOwner(int ownerId) {
        return ExceptionUtil.checkNotFoundByOwner(repository.getByOwner(ownerId), ownerId);
    }

    @Override
    @Transactional
    public void deleteByOwner(int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.deleteByOwner(ownerId), ownerId);
    }
}
