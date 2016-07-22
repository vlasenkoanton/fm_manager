package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import com.avlasenko.sb.fmmanager.util.dto.converter.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Service
public class IndividualServiceImpl implements IndividualService {

    private IndividualJpaRepository individualRepository;
    private DocumentJpaRepository documentRepository;

    @Autowired
    public IndividualServiceImpl(IndividualJpaRepository individualRepository,
                                 DocumentJpaRepository documentRepository) {
        this.individualRepository = individualRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Individual> getAll() {
        return new ArrayList<>(individualRepository.getAll());
    }

    @Override
    public Individual getWithAllProperties(int id) {
        return individualRepository.getWithAllProperties(id);
    }

    @Override
    @Transactional
    public Integer save(IndividualQuickFormDTO dto) {
        //purpose of this method creating only clients. Non-clients(related persons) is creating in "saveProxy" method.
        dto.setClient(true);

        Document document = dto.getDocument();
        Individual individual = DTOConverter.convertToEntity(dto);
        individualRepository.save(individual);
        //if document field had included into DTO, would have a problems with lost foreign key for "document"
        // when trying to persist individual
        document.setOwner(individual);
        documentRepository.save(document);
        return individual.getId();
    }

    @Override
    @Transactional
    public void updateWithoutRelations(Individual individual, int id) {
        individualRepository.updateWithoutRelations(individual, id);
    }

    @Override
    @Transactional
    public void saveProxy(IndividualQuickFormDTO dto, int ownerId, String type) {
        dto.setClient(false);
        Document document = dto.getDocument();
        Individual proxy = DTOConverter.convertToEntity(dto);
        switch (type) {
            case "accOpener": individualRepository.saveAccOpener(proxy, ownerId);
                break;
            case "representative": individualRepository.saveRepresentative(proxy, ownerId);
                break;
        }
        document.setOwner(proxy);
        documentRepository.save(document);
    }

    @Override
    @Transactional
    public void delete(int id) {
        individualRepository.delete(id);
    }
}
