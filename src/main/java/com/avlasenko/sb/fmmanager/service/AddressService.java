package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface AddressService {
    void saveByOwner(Address address, int ownerId) throws EntryNotFoundException;

    Address getByOwner(int ownerId) throws EntryNotFoundException;

    void deleteByOwner(int ownerId) throws EntryNotFoundException;
}
