package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
public interface ClientService {

    Client save(Client client);

    void delete(int id);

    Client getById(int id);

    Collection<Client> getAll();
}
