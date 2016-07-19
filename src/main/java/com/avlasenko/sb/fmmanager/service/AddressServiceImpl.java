package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressJpaRepository repository;


    @Override
    @Transactional
    public void save(Address address, int clientId) {
        ExceptionUtil.checkNotFoundByClient(repository.save(address, clientId), clientId);
    }

    @Override
    public Address get(int id, int clientId) {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, clientId), clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, clientId), clientId);
    }
}
