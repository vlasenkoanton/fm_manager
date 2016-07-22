package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface ContactService {
    void save(Contact contact, int ownerId) throws EntryNotFoundException;

    Contact getByOwner(int ownerId) throws EntryNotFoundException;

    void delete(int ownerId) throws EntryNotFoundException;
}
