package com.avlasenko.sb.fmmanager.repository.fminfo;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.GenericJpaRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Repository
@Transactional(readOnly = true)
public class FmInfoJpaRepositoryImpl extends GenericJpaRepository<FmInfo> implements FmInfoJpaRepository {
    public FmInfoJpaRepositoryImpl() {
        super(FmInfo.class);
    }

    @Override
    public FmInfo save(FmInfo fmInfo, int ownerId) {
        if (!fmInfo.isNew() && getByOwner(ownerId) == null) {
            return null;
        }
        if (fmInfo.isNew()) {
            Individual individual = entityManager.getReference(Individual.class, ownerId);
            individual.setFmInfo(fmInfo);
            return fmInfo;
        }
        return save(fmInfo);
    }

    @Override
    public FmInfo getByOwner(int ownerId) {
        TypedQuery<FmInfo> query = entityManager.createNamedQuery(FmInfo.GET_BY_OWNER, FmInfo.class);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int ownerId) {
        FmInfo fmInfo = getByOwner(ownerId);
        if (fmInfo == null) {
            return false;
        }
        delete(fmInfo);
        return true;
    }
}
