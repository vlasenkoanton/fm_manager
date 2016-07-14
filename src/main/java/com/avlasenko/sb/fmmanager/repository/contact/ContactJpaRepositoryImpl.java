package com.avlasenko.sb.fmmanager.repository.contact;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Contact;
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
    public Contact save(Contact contact, int clientId) {
        if (!contact.isNew() && get(contact.getId(), clientId) == null) {
            return null;
        }

        if (contact.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            client.setContact(contact);
            entityManager.merge(client);
            return contact;
        } else {
            return save(contact);
        }
    }

    @Override
    public Contact get(int id, int clientId) {
        TypedQuery<Contact> query = entityManager.createNamedQuery(Contact.GET_BY_CLIENT, Contact.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId) {
        if (get(id, clientId) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(Contact.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }
}
