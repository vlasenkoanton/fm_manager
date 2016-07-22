package com.avlasenko.sb.fmmanager.repository.individual;

import com.avlasenko.sb.fmmanager.model.Individual;
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
public class IndividualJpaRepositoryImpl extends GenericJpaRepository<Individual> implements IndividualJpaRepository {

    public IndividualJpaRepositoryImpl() {
        super(Individual.class);
    }

    @Override
    public Individual getWithAllProperties(int id) {
        EntityGraph<?> entityGraph = entityManager.createEntityGraph(Individual.ALL_RELATIONS);
        Map<String, Object> props = new HashMap<>();
        props.put("javax.persistence.loadgraph", entityGraph);
        return entityManager.find(Individual.class, id, props);
    }

    @Override
    public Individual updateWithoutRelations(Individual individual, int id) {
        if (individual.getId() != id) {
            return null;
        }

        Query query = entityManager.createNamedQuery(Individual.WITHOUT_RELATIONS);
        query
                .setParameter("id", id)
                .setParameter("identNumber", individual.getIdentNumber())
                .setParameter("firstName", individual.getFirstName())
                .setParameter("lastName", individual.getLastName())
                .setParameter("middleName", individual.getMiddleName())
                .setParameter("dateBirth", individual.getDateBirth())
                .setParameter("placeBirth", individual.getPlaceBirth())
                .setParameter("resident", individual.isResident())
                .setParameter("citizenship", individual.getCitizenship())
                .setParameter("responsible", individual.getResponsible())
                .setParameter("pep", individual.isPep());

        return query.executeUpdate() == 1 ? individual : null;
    }

    @Override
    public Individual saveAccOpener(Individual proxy, int ownerId) {
        Individual individual = entityManager.getReference(Individual.class, ownerId);
        individual.setAccOpener(proxy);
        return proxy;
    }

    @Override
    public Individual saveRepresentative(Individual proxy, int ownerId) {
        Individual individual = entityManager.getReference(Individual.class, ownerId);
        individual.setRepresentative(proxy);
        return proxy;
    }

    @Override
    public boolean delete(int id) {
        Individual individual = entityManager.getReference(Individual.class, id);
        try {
            delete(individual);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
