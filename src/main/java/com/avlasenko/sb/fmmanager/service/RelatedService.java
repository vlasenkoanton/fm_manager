package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Related;

import javax.persistence.EntityNotFoundException;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
public interface RelatedService {
    void save(Related related, int clientId, String type) throws EntityNotFoundException;

    Related get(int id, int clientId, String type) throws EntityNotFoundException;

    void delete(int id, int clientId, String type) throws EntityNotFoundException;
}
