package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface AddressJpaRepository extends GenericBaseRepository<Address> {
    Address save(Address address, int clientId);

    Address get(int id, int clientId); //TODO remove code duplicate in all similar repos using Criteria API and generics

    boolean delete(int id, int clientId);
}
