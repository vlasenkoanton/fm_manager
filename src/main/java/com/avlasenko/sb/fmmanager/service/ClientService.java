package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
public interface ClientService {

    Client save(Client client);

    Client saveWithRelations(Client client);

    void delete(int id);

    Client getById(int id);

    Collection<Client> getAll();

    Client setAddress(int id, Address address);
}
