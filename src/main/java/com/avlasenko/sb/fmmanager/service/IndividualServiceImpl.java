package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.repository.document.DocumentJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import com.avlasenko.sb.fmmanager.repository.user.UserJpaRepository;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import com.avlasenko.sb.fmmanager.util.dto.converter.DTOConverter;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import com.avlasenko.sb.fmmanager.util.exception.ExceptionUtil;
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
    private UserJpaRepository userRepository;

    @Autowired
    public IndividualServiceImpl(IndividualJpaRepository individualRepository, UserJpaRepository userRepository) {
        this.individualRepository = individualRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Individual> getAll() {
        return new ArrayList<>(individualRepository.getAll());
    }

    @Override
    public Individual getWithAllProperties(int id) {
        return ExceptionUtil.checkNotFound(individualRepository.getWithAllProperties(id), "with id=" + id);
    }

    @Override
    @Transactional
    public Integer saveClient(Individual individual) {
        if (individual.getDocuments() != null && !individual.getDocuments().isEmpty()) {
            Document document = individual.getDocuments().stream().findFirst().orElse(null);
            document.setOwner(individual);
        }

        //purpose of this method creating only clients. Non-clients(related persons) is creating in "saveProxy" method.
        individual.setClient(true);
        setResponsible(individual);
        individual.setInitialProfileFill(LocalDate.now());

        individualRepository.save(individual);
        return individual.getId();
    }

    @Override
    @Transactional
    public void updateWithoutRelations(Individual individual, int id) {
        ExceptionUtil.checkNotFound(individualRepository.updateWithoutRelations(individual, id), "with id=" + id);
    }

    @Override
    @Transactional
    public void saveProxy(Individual proxy, int ownerId, String type) {
        if (proxy.getDocuments() != null && !proxy.getDocuments().isEmpty()) {
            Document document = proxy.getDocuments().stream().findFirst().orElse(null);
            document.setOwner(proxy);
        }

        proxy.setClient(false);
        setResponsible(proxy);
        proxy.setInitialProfileFill(LocalDate.now());
        switch (type) {
            case "accOpener":
                ExceptionUtil.checkNotFoundByOwner(individualRepository.saveAccOpener(proxy, ownerId), ownerId);
                break;
            case "representative":
                ExceptionUtil.checkNotFoundByOwner(individualRepository.saveRepresentative(proxy, ownerId), ownerId);
                break;
            default:
                throw new IllegalArgumentException("Unexpected method argument \"type\". " +
                        "Should be \"accOpener\" or \"representative\" but was \"" + type + "\"");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        ExceptionUtil.checkNotFound(individualRepository.delete(id), "with id=" + id);
    }

    //When creating new individual automatically set responsible to current authenticated user
    private void setResponsible(Individual individual) {
        User user = userRepository.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        individual.setResponsible(user);
    }
}
