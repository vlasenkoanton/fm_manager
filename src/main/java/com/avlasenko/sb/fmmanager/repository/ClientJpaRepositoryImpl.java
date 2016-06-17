package com.avlasenko.sb.fmmanager.repository;

import com.avlasenko.sb.fmmanager.model.Client;
import org.springframework.stereotype.Repository;

/**
 * Created by A. Vlasenko on 15.06.2016.
 */
@Repository
public class ClientJpaRepositoryImpl extends GenericJpaRepository<Client> implements ClientJpaRepository {

    public ClientJpaRepositoryImpl() {
        super(Client.class);
    }
}
