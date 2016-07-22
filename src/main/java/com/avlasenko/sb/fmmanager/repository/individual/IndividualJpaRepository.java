package com.avlasenko.sb.fmmanager.repository.individual;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 14.06.2016.
 */

public interface IndividualJpaRepository extends GenericBaseRepository<Individual> {

    Individual getWithAllProperties(int id);

    Individual updateWithoutRelations(Individual individual, int id);

    Individual saveAccOpener(Individual proxy, int ownerId);

    Individual saveRepresentative(Individual proxy, int ownerId);

    boolean delete(int id);
}
