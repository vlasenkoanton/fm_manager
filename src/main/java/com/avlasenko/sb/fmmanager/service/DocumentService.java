package com.avlasenko.sb.fmmanager.service;


import com.avlasenko.sb.fmmanager.model.Document;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface DocumentService {

    void save(Document document, int clientId);

    Document get(int id, int clientId);

    void delete(int id, int clientId);
}
