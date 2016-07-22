package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface AddressJpaRepository extends GenericBaseRepository<Address> {
    Address save(Address address, int ownerId);

    Address getByOwner(int ownerId);

    boolean delete(int ownerId);
}
