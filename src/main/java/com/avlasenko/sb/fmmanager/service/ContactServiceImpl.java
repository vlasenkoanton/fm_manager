package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.contact.ContactJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactJpaRepository repository;

    @Override
    @Transactional
    public void save(Contact contact, int clientId) {
        repository.save(contact, clientId);
    }

    @Override
    public Contact get(int id, int clientId) {
        return repository.get(id, clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        repository.delete(id, clientId);
    }
}
