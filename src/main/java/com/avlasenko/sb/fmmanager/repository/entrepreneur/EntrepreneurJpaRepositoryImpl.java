package com.avlasenko.sb.fmmanager.repository.entrepreneur;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.model.Individual;
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
public class EntrepreneurJpaRepositoryImpl extends GenericJpaRepository<EntrepreneurInfo> implements EntrepreneurJpaRepository {
    public EntrepreneurJpaRepositoryImpl() {
        super(EntrepreneurInfo.class);
    }

    @Override
    public EntrepreneurInfo save(EntrepreneurInfo entrepreneurInfo, int ownerId) {
        if (!entrepreneurInfo.isNew() && getByOwner(ownerId) == null) {
            return null;
        }
        if(entrepreneurInfo.isNew()) {
            Individual individual = entityManager.getReference(Individual.class, ownerId);
            individual.setEntrepreneurInfo(entrepreneurInfo);
            return entrepreneurInfo;
        }
        return save(entrepreneurInfo);
    }

    @Override
    public EntrepreneurInfo getByOwner(int ownerId) {
        TypedQuery<EntrepreneurInfo> query = entityManager
                .createNamedQuery(EntrepreneurInfo.GET_BY_OWNER, EntrepreneurInfo.class);
        query.setParameter("ownerId", ownerId);
        return DataAccessUtils.singleResult(query.getResultList());
    }

    @Override
    public boolean delete(int ownerId) {
        EntrepreneurInfo entrepreneurInfo = getByOwner(ownerId);
        if (entrepreneurInfo == null) {
            return false;
        }
        delete(entrepreneurInfo);
        return true;
    }
}
