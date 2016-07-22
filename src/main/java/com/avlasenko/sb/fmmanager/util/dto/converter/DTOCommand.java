package com.avlasenko.sb.fmmanager.util.dto.converter;

import com.avlasenko.sb.fmmanager.model.BaseEntity;
import com.avlasenko.sb.fmmanager.util.dto.DTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
interface DTOCommand<E extends BaseEntity, D extends DTO> {
    MapperFactory mapper = new DefaultMapperFactory.Builder().build();


    default D convertToDTO(E entity) {
        throw new UnsupportedOperationException();
    }

    default E convertToEntity(D dto) {
        throw new UnsupportedOperationException();
    }
}
