package com.avlasenko.sb.fmmanager.repository.client;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 14.06.2016.
 */

public interface ClientJpaRepository extends GenericBaseRepository<Client> {

    Client getWithAllProperties(int id);

    Client updateWithoutRelations(Client client, int id);
}
