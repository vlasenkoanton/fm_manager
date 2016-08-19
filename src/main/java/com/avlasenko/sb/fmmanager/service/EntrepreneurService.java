package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface EntrepreneurService {
    void saveByOwner(EntrepreneurInfo entrepreneurInfo, int ownerId);

    EntrepreneurInfo getByOwner(int ownerId);

    void deleteByOwner(int ownerId);
}
