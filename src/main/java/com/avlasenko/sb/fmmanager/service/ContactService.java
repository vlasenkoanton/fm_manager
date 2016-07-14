package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Contact;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface ContactService {
    void save(Contact contact, int clientId);

    Contact get(int id, int clientId);

    void delete(int id, int clientId);
}
