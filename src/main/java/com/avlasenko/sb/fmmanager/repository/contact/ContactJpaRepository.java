package com.avlasenko.sb.fmmanager.repository.contact;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface ContactJpaRepository extends GenericBaseRepository<Contact> {
    Contact save(Contact contact, int ownerId);

    Contact getByOwner(int ownerId);

    boolean delete(int ownerId);
}
