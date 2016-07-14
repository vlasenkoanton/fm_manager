package com.avlasenko.sb.fmmanager.repository.client;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by A. Vlasenko on 15.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class ClientJpaRepositoryImpl extends GenericJpaRepository<Client> implements ClientJpaRepository {

    public ClientJpaRepositoryImpl() {
        super(Client.class);
    }

    @Override
    public Client getWithAllProperties(int id) {
        EntityGraph<?> graph = entityManager.createEntityGraph(Client.GRAPH);
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", graph);
        return entityManager.find(Client.class, id, hints);
    }

    @Override
    public Client updateWithoutRelations(Client client, int id) {
        if (client.getId() != id) {
            return null;
        }

        Query query = entityManager.createNamedQuery(Client.UPDATE_WITHOUT_RELATIONS);
        query
                .setParameter("id", id)
                .setParameter("identNumber", client.getIdentNumber())
                .setParameter("firstName", client.getFirstName())
                .setParameter("lastName", client.getLastName())
                .setParameter("middleName", client.getMiddleName())
                .setParameter("dateBirth", client.getDateBirth())
                .setParameter("placeBirth", client.getPlaceBirth())
                .setParameter("resident", client.isResident())
                .setParameter("citizenship", client.getCitizenship())
                .setParameter("responsible", client.getResponsible())
                .setParameter("pep", client.isPep());

        return query.executeUpdate() == 1 ? client : null;
    }


}
