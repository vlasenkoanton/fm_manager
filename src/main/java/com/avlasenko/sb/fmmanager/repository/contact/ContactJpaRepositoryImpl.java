package com.avlasenko.sb.fmmanager.repository.contact;

import com.avlasenko.sb.fmmanager.model.Contact;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class ContactJpaRepositoryImpl extends GenericJpaRepository<Contact> implements ContactJpaRepository {
    public ContactJpaRepositoryImpl() {
        super(Contact.class);
    }

    @Override
    public Contact save(Contact contact, int ownerId) {
        if (!contact.isNew() && getByOwner(ownerId) == null) {
            return null;
        }
        if (contact.isNew()) {
            Individual individual = entityManager.getReference(Individual.class, ownerId);
            individual.setContact(contact);
            return contact;
        }
        return save(contact);
    }

    @Override
    public Contact getByOwner(int ownerId) {
        TypedQuery<Contact> query = entityManager.createNamedQuery(Contact.GET_BY_OWNER, Contact.class);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int ownerId) {
        Contact contact = getByOwner(ownerId);
        if (contact == null) {
            return false;
        }
        delete(contact);
        return true;
    }
}
