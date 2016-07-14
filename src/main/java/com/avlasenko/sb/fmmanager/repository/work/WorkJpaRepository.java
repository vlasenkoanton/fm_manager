package com.avlasenko.sb.fmmanager.repository.work;

import com.avlasenko.sb.fmmanager.model.Work;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public interface WorkJpaRepository extends GenericBaseRepository<Work> {

    Work save(Work work, int clientId);

    Work get(int id, int clientId);

    boolean delete(int id, int clientId);
}
