package com.avlasenko.sb.fmmanager.repository.related;

import com.avlasenko.sb.fmmanager.model.Related;
import com.avlasenko.sb.fmmanager.repository.GenericBaseRepository;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
public interface RelatedJpaRepository extends GenericBaseRepository<Related> {
    Related save(Related related, int clientId, String type);

    Related get(int id, int clientId, String type);

    boolean delete(int id, int clientId, String type);

    Related getWithAllProperties(int id);

    Related updateWithoutRelations(Related related, int id);
}
