package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.contact.ContactJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
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
    public void save(Contact contact, int ownerId) throws EntryNotFoundException {
        repository.save(contact, ownerId);
    }

    @Override
    public Contact getByOwner(int ownerId) throws EntryNotFoundException {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void delete(int ownerId) throws EntryNotFoundException {
        repository.delete(ownerId);
    }
}
