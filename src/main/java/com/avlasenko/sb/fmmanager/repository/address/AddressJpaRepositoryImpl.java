package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
@Repository
public class AddressJpaRepositoryImpl extends GenericJpaRepository<Address> implements AddressJpaRepository {
    public AddressJpaRepositoryImpl() {
        super(Address.class);
    }

    @Override
    public Address saveByOwner(Address address, int ownerId) {
        if (!address.isNew() && (getByOwner(ownerId) == null || !getByOwner(ownerId).getId().equals(address.getId()))) {
            return null;
        }
        if (address.isNew()) {
            Individual individual = entityManager.getReference(Individual.class, ownerId);
            individual.setAddress(address);
            return address;
        }
        return save(address);
    }

    @Override
    public Address getByOwner(int ownerId) {
        TypedQuery<Address> query = entityManager.createNamedQuery(Address.GET_BY_OWNER, Address.class);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean deleteByOwner(int ownerId) {
        Address address = getByOwner(ownerId);
        if (address == null) {
            return false;
        }
        delete(address);
        return true;
    }
}
