package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.contact.ContactJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
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
        ExceptionUtil.checkNotFoundByClient(repository.save(contact, clientId), clientId);
    }

    @Override
    public Contact get(int id, int clientId) {
        return ExceptionUtil.checkNotFoundByClient(repository.get(id, clientId), clientId);
    }

    @Override
    @Transactional
    public void delete(int id, int clientId) {
        ExceptionUtil.checkNotFoundByClient(repository.delete(id, clientId), clientId);
    }
}
