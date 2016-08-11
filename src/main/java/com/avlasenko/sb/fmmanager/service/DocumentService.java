package com.avlasenko.sb.fmmanager.service;


import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface DocumentService {

    void saveByOwner(Document document, int ownerId);
    Document getByOwner(int id, int ownerId);
    void deleteByOwner(int id, int ownerId);
}
