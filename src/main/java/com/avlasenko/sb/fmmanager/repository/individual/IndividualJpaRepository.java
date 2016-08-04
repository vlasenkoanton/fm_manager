package com.avlasenko.sb.fmmanager.repository.individual;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.06.2016.
 */
@Transactional
public interface IndividualJpaRepository extends GenericBaseRepository<Individual> {

    Individual getWithAllProperties(int id);

    Individual updateWithoutRelations(Individual individual, int id);

    Individual saveAccOpener(Individual proxy, int ownerId);

    Individual saveRepresentative(Individual proxy, int ownerId);

    boolean delete(int id);
}
