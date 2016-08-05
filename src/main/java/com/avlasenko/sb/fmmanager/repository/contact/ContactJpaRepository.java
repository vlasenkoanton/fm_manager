package com.avlasenko.sb.fmmanager.repository.contact;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Transactional
public interface ContactJpaRepository extends GenericBaseRepository<Contact> {
    Contact saveByOwner(Contact contact, int ownerId);

    Contact getByOwner(int ownerId);

    boolean deleteByOwner(int ownerId);
}
