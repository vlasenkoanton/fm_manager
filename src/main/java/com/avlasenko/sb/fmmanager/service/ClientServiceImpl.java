package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.ClientJpaRepository;
import com.avlasenko.sb.fmmanager.repository.DocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientJpaRepository clientJpaRepository;
    private DocumentJpaRepository documentJpaRepository;

    @Autowired
    public ClientServiceImpl(ClientJpaRepository clientJpaRepository, DocumentJpaRepository documentJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
        this.documentJpaRepository = documentJpaRepository;
    }

    @Override
    @Transactional
    public Client save(Client client) {
        if (client.getId() != 0) {
            return clientJpaRepository.update(client);
        }
        return clientJpaRepository.save(client);
    }

    @Override
    @Transactional
    public void delete(int id) {
        clientJpaRepository.delete(clientJpaRepository.get(id));
    }

    @Override
    @Transactional
    public Client getById(int id) {
        return clientJpaRepository.get(id);
    }

    @Override
    @Transactional
    public Collection<Client> getAll() {
        return clientJpaRepository.getAll();
    }


}
