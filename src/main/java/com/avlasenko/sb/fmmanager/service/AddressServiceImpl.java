package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
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
        repository.save(address, clientId);
    }

    @Override
    public Address get(int id, int clientId) {
        return repository.get(id, clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        repository.delete(id, clientId);
    }
}
