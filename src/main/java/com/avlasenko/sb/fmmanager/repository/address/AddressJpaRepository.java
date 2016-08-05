package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
@Transactional
public interface AddressJpaRepository extends GenericBaseRepository<Address> {
    Address saveByOwner(Address address, int ownerId);

    Address getByOwner(int ownerId);

    boolean deleteByOwner(int ownerId);
}
