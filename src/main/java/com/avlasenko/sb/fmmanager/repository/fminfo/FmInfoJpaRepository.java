package com.avlasenko.sb.fmmanager.repository.fminfo;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Transactional
public interface FmInfoJpaRepository extends GenericBaseRepository<FmInfo> {
    FmInfo saveByOwner(FmInfo fmInfo, int ownerId);

    FmInfo getByOwner(int ownerId);

    boolean deleteByOwner(int ownerId);
}
