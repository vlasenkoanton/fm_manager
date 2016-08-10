package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;

import java.util.List;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
public interface IndividualService {
    List<Individual> getAll();

    Individual getWithAllProperties(int id);

    Integer saveClient(Individual individual);

    void updateWithoutRelations(Individual individual, int id);

    void saveProxy(Individual proxy, int ownerId, String type);

    void delete(int id);
}
