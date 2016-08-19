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
    public void saveByOwner(Contact contact, int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.saveByOwner(contact, ownerId), ownerId);
    }

    @Override
    public Contact getByOwner(int ownerId) {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void deleteByOwner(int ownerId) {
        ExceptionUtil.checkNotFoundByOwner(repository.deleteByOwner(ownerId), ownerId);
    }
}
