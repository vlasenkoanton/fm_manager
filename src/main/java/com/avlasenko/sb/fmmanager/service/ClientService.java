package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Client;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
public interface ClientService {

    Client save(Client client);

    void updateWithoutRelations(Client client, int id);

    void delete(int id);

    Client getById(int id);

    Client getWithAllProperties(int id);

    Collection<Client> getAll();
}
