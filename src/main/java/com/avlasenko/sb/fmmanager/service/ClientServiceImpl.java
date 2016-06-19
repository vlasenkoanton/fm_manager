package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.ClientJpaRepository;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
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
    private AddressJpaRepository addressJpaRepository;

    @Autowired
    public ClientServiceImpl(ClientJpaRepository clientJpaRepository, AddressJpaRepository addressJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
        this.addressJpaRepository = addressJpaRepository;
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public Client saveWithRelations(Client client) {
        int id = client.getId();
        Client fromDB = getById(id);
        Address address = fromDB.getAddress();

        client.setAddress(address);
        return client;
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

    @Override
    @Transactional
    public Client setAddress(int id, Address address) {
        addressJpaRepository.save(address);
        Client client = clientJpaRepository.get(id);
        client.setAddress(address);
        return clientJpaRepository.save(client);
    }

}
