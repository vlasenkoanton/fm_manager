package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.fminfo.FmInfoJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
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
    public void save(FmInfo fmInfo, int clientId) throws EntryNotFoundException {
        ExceptionUtil.checkNotFoundByClient(repository.save(fmInfo, clientId), clientId);
    }

    @Override
    public FmInfo get(int id, int clientId) throws EntryNotFoundException {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, clientId), clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) throws EntryNotFoundException {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, clientId), clientId);
    }
}
