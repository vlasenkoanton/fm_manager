package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface ContactService {
    void saveByOwner(Contact contact, int ownerId);

    Contact getByOwner(int ownerId);

    void deleteByOwner(int ownerId);
}
