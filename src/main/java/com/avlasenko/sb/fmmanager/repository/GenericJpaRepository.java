package com.avlasenko.sb.fmmanager.repository;

import com.avlasenko.sb.fmmanager.model.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by A. Vlasenko on 15.06.2016.
 */
public class GenericJpaRepository<T extends BaseEntity> implements GenericBaseRepository<T> {

    private Class<T> clazz;

    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericJpaRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T get(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Collection<T> getAll() {
        return entityManager.createQuery(
                String.format("select e from %s e", clazz.getSimpleName()), clazz
        ).getResultList();
    }
}
