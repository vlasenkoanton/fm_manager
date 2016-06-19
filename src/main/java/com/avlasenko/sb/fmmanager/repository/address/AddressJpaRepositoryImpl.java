package com.avlasenko.sb.fmmanager.repository.address;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by A. Vlasenko on 18.06.2016.
 */
@Repository
public class AddressJpaRepositoryImpl extends GenericJpaRepository<Address> implements AddressJpaRepository {
    public AddressJpaRepositoryImpl() {
        super(Address.class);
    }

}
