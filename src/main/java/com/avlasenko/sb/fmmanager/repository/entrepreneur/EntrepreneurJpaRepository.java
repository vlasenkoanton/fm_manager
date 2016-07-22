package com.avlasenko.sb.fmmanager.repository.entrepreneur;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface EntrepreneurJpaRepository extends GenericBaseRepository<EntrepreneurInfo> {
    EntrepreneurInfo save(EntrepreneurInfo entrepreneurInfo, int ownerId);

    EntrepreneurInfo getByOwner(int ownerId);

    boolean delete(int ownerId);
}
