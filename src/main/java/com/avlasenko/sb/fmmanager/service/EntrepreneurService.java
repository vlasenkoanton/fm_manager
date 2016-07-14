package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface EntrepreneurService {
    void save(EntrepreneurInfo entrepreneurInfo, int clientId);

    EntrepreneurInfo get(int id, int clientId);

    void delete(int id, int clientId);
}
