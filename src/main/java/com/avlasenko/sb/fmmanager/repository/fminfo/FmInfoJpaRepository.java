package com.avlasenko.sb.fmmanager.repository.fminfo;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
public interface FmInfoJpaRepository extends GenericBaseRepository<FmInfo> {
    FmInfo save(FmInfo fmInfo, int ownerId);

    FmInfo getByOwner(int ownerId);

    boolean delete(int ownerId);
}
