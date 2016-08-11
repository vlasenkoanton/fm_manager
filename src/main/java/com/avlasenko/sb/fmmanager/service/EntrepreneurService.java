package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface EntrepreneurService {
    void saveByOwner(EntrepreneurInfo entrepreneurInfo, int ownerId) throws EntryNotFoundException;

    EntrepreneurInfo getByOwner(int ownerId);

    void deleteByOwner(int ownerId);
}
