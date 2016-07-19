package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface AddressService {
    void save(Address address, int clientId) throws EntryNotFoundException;

    Address get(int id, int clientId) throws EntryNotFoundException;

    void delete(int id, int clientId) throws EntryNotFoundException;
}
