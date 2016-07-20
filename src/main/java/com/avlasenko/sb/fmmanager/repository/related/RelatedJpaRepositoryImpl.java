package com.avlasenko.sb.fmmanager.repository.related;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.model.Related;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class RelatedJpaRepositoryImpl extends GenericJpaRepository<Related> implements RelatedJpaRepository {
    public RelatedJpaRepositoryImpl() {
        super(Related.class);
    }

    @Override
    public Related save(Related related, int clientId, String type) {
        if (!related.isNew() && get(related.getId(), clientId, type) == null) {
            return null;
        }

        if (related.isNew()) {
            Client client = entityManager.getReference(Client.class, clientId);
            switch (type) {
                case Related.GET_OPENER_BY_CLIENT: client.setAccOpener(related);
                    break;
                case Related.GET_REPRESENTATIVE_BY_CLIENT: client.setRepresentative(related);   //TODO check if this(and similar to this) could be simplified
                    break;
            }
            return related;
        } else {
            return updateWithoutRelations(related, clientId);
        }
    }

    @Override
    public Related get(int id, int clientId, String type) {
        TypedQuery<Related> query = entityManager.createNamedQuery(type, Related.class);
        query.setParameter("id", id)
                .setParameter("clientId", clientId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int id, int clientId, String type) {
        if (get(id, clientId, type) == null) {
            return false;
        }
        Query query = entityManager.createNamedQuery(Related.DELETE_BY_CLIENT);
        query.setParameter("id", id);
        return query.executeUpdate() == 1;
    }

    @Override
    public Related getWithAllProperties(int id) {
        EntityGraph<?> graph = entityManager.createEntityGraph(Related.RELATED_GET_WITH_RELATIONS);
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", graph);
        return entityManager.find(Related.class, id, hints);
    }

    @Override
    public Related updateWithoutRelations(Related related, int id) {
        if (related.getId() != id) {
            return null;
        }
        Query query = entityManager.createNamedQuery(Related.RELATED_UPDATE_WITHOUT_RELATIONS);
        query
                .setParameter("id", id)
                .setParameter("identNumber", related.getIdentNumber())
                .setParameter("firstName", related.getFirstName())
                .setParameter("lastName", related.getLastName())
                .setParameter("middleName", related.getMiddleName())
                .setParameter("dateBirth", related.getDateBirth())
                .setParameter("placeBirth", related.getPlaceBirth())
                .setParameter("resident", related.isResident())
                .setParameter("citizenship", related.getCitizenship());
        return query.executeUpdate() == 1 ? related : null;
    }
}
