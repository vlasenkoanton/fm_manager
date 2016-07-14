package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class AddressJpaRepositoryImpl extends GenericJpaRepository<Address> implements AddressJpaRepository {
    public AddressJpaRepositoryImpl() {
        super(Address.class);
    }

    @Override
    public Address save(Address address, int clientId) {
        if (!address.isNew() && get(address.getId(), clientId) == null) {
            return null;
        }

        if (address.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            client.setAddress(address);
            entityManager.merge(client);
            return address;
        } else {
            return save(address);
        }
    }

    @Override
    public Address get(int id, int clientId) {
        TypedQuery<Address> query = entityManager.createNamedQuery(Address.GET_BY_CLIENT, Address.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        if (get(id, clientId) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(Address.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
