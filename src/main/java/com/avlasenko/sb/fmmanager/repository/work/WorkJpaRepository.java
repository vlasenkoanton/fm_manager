package com.avlasenko.sb.fmmanager.repository.work;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
@Transactional
public interface WorkJpaRepository extends GenericBaseRepository<Work> {

    Work saveByOwner(Work work, int ownerId);

    Work getByOwner(int ownerId);

    boolean deleteByOwner(int ownerId);
}
