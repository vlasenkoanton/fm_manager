package com.avlasenko.sb.fmmanager.repository.work;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class WorkJpaRepositoryImpl extends GenericJpaRepository<Work> implements WorkJpaRepository {

    public WorkJpaRepositoryImpl() {
        super(Work.class);
    }

    @Override
    public Work save(Work work, int ownerId) {
        if (!work.isNew() && getByOwner(ownerId) == null) {
            return null;
        }
        if(work.isNew()) {
            Individual individual = entityManager.getReference(Individual.class, ownerId);
            individual.setWork(work);
            return work;
        }
        return save(work);
    }

    @Override
    public Work getByOwner(int ownerId) {
        TypedQuery<Work> query = entityManager.createNamedQuery(Work.GET_BY_OWNER, Work.class);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int ownerId) {
        Work work = getByOwner(ownerId);
        if (work == null) {
            return false;
        }
        delete(work);
        return true;
    }
}
