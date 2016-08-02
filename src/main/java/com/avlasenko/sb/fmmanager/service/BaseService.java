package com.avlasenko.sb.fmmanager.service;

/**
 * Created by A. Vlasenko on 02.08.2016.
 */
public interface BaseService<T> {
    void saveByOwner(T entity, Integer ownerId);
    T getByOwner(Integer id, Integer ownerId);
    void deleteByOwner(Integer id, Integer ownerId);
}
