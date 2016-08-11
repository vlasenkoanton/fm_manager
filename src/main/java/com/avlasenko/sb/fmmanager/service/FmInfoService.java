package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
public interface FmInfoService {
    void saveByOwner(FmInfo fmInfo, int ownerId);

    FmInfo getByOwner(int ownerId);

    void deleteByOwner(int ownerId);
}
