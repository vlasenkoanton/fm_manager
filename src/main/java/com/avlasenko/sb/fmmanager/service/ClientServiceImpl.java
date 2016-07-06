package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.client.ClientJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientJpaRepository repository;

    @Override
    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(repository.get(id));
    }

    @Override
    @Transactional
    public Client getById(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public Client getWithAllProperties(int id) {
        return repository.getWithAllProperties(id);
    }

    @Override
    @Transactional
    public Collection<Client> getAll() {
        return repository.getAll();
    }

}
