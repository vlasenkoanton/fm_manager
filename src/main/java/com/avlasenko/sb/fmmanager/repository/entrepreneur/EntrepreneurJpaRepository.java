package com.avlasenko.sb.fmmanager.repository.entrepreneur;

import com.avlasenko.sb.fmmanager.model.EntrepreneurInfo;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Transactional
public interface EntrepreneurJpaRepository extends GenericBaseRepository<EntrepreneurInfo> {
    EntrepreneurInfo saveByOwner(EntrepreneurInfo entrepreneurInfo, int ownerId);

    EntrepreneurInfo getByOwner(int ownerId);

    boolean deleteByOwner(int ownerId);
}
