package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepository;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import com.avlasenko.sb.fmmanager.util.dto.converter.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A. Vlasenko on 16.06.2016.
 */
@Service
public class IndividualServiceImpl implements IndividualService {

    private IndividualJpaRepository individualRepository;
    private DocumentJpaRepository documentRepository;
    private UserJpaRepository userRepository;

    @Autowired
    public IndividualServiceImpl(IndividualJpaRepository individualRepository,
                                 DocumentJpaRepository documentRepository, UserJpaRepository userRepository) {
        this.individualRepository = individualRepository;
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
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
        Document document = dto.getDocument();
        Individual individual = DTOConverter.convertToEntity(dto);

        //purpose of this method creating only clients. Non-clients(related persons) is creating in "saveProxy" method.
        individual.setClient(true);
        setResponsible(individual);
        individual.setInitialProfileFill(LocalDate.now());
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
        Document document = dto.getDocument();
        Individual proxy = DTOConverter.convertToEntity(dto);
        proxy.setClient(false);
        setResponsible(proxy);
        proxy.setInitialProfileFill(LocalDate.now());
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

    //When creating new individual automatically set responsible to current authenticated user
    private void setResponsible(Individual individual) {
        User user = userRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        individual.setResponsible(user);
    }
}
