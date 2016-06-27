package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.ClientJpaRepository;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

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
        return clientJpaRepository.save(client);
    }

    @Override
    @Transactional
    public Client saveWithRelations(Client client) {
        //TODO find more precise implementation
        int id = client.getId();

        Client fromDb = clientJpaRepository.get(id);
        Address address = fromDb.getAddress();
        List<Document> documentList = fromDb.getDocuments();
        Work work = fromDb.getWork();
        Contact contact = fromDb.getContact();

        client.setAddress(address);
        client.setDocuments(documentList);
        client.setWork(work);
        client.setContact(contact);

        clientJpaRepository.save(client);
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
    public Document getDocument(int id, int ownerId) {
        return documentJpaRepository.get(id, ownerId);
    }

    @Override
    @Transactional
    public Collection<Client> getAll() {
        return clientJpaRepository.getAll();
    }

}
