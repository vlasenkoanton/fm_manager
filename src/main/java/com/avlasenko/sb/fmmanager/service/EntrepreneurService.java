package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface EntrepreneurService {
    void save(EntrepreneurInfo entrepreneurInfo, int clientId) throws EntryNotFoundException;

    EntrepreneurInfo get(int id, int clientId) throws EntryNotFoundException;

    void delete(int id, int clientId) throws EntryNotFoundException;
}
