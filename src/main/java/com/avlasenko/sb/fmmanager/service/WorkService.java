package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface WorkService {
    void saveByOwner(Work work, int ownerId);

    Work getByOwner(int ownerId);

    void deleteByOwner(int ownerId);
}
