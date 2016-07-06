package com.avlasenko.sb.fmmanager.service;


import com.avlasenko.sb.fmmanager.model.Document;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface DocumentService {

    void save(Document document, int ownerId);

    Document getByOwner(int id, int ownerId);

}
