package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface WorkService {
    void save(Work work, int ownerId) throws EntryNotFoundException;

    Work getByOwner(int ownerId) throws EntryNotFoundException;

    void delete(int ownerId) throws EntryNotFoundException;
}
