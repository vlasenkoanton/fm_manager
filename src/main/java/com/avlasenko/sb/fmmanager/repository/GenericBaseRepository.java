package com.avlasenko.sb.fmmanager.repository;

import com.avlasenko.sb.fmmanager.model.BaseEntity;

import java.util.Collection;

/**
 * Created by A. Vlasenko on 14.06.2016.
 */
public interface GenericBaseRepository<T extends BaseEntity> {
    T save(T entity);

    void delete(T entity);

    T get(int id);

    Collection<T> getAll();
}
