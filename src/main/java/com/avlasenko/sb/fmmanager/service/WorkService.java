package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.Work;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface WorkService {
    void save(Work work, int clientId);

    Work get(int id, int clientId);

    void delete(int id, int clientId);
}
