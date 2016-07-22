package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
public interface FmInfoService {
    void save(FmInfo fmInfo, int ownerId) throws EntryNotFoundException;

    FmInfo getByOwner(int ownerId) throws EntryNotFoundException;

    void delete(int ownerId) throws EntryNotFoundException;
}
