package com.avlasenko.sb.fmmanager.service;


import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;

/**
 * Created by A. Vlasenko on 06.07.2016.
 */
public interface DocumentService {

    void save(Document document, int ownerId) throws EntryNotFoundException;

    Document get(int id, int ownerId) throws EntryNotFoundException;

    void delete(int id, int ownerId) throws EntryNotFoundException;
}
