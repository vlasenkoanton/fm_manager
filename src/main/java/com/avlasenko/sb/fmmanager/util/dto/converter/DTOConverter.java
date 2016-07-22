package com.avlasenko.sb.fmmanager.util.dto.converter;

import com.avlasenko.sb.fmmanager.model.BaseEntity;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.util.dto.DTO;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
public abstract class DTOConverter {
    private static final Map<String, DTOCommand> map = new HashMap<>();

    private DTOConverter(){}

    static {
        map.put(Individual.class.getSimpleName(), IndividualQuickFormCommand.getInstance());
        map.put(IndividualQuickFormDTO.class.getSimpleName(), IndividualQuickFormCommand.getInstance());
    }

    @SuppressWarnings("unchecked")
    public static <E extends BaseEntity, D extends DTO> D convertToDto(E entity) {
        return (D) map.get(entity.getClass().getSimpleName()).convertToDTO(entity);
    }

    @SuppressWarnings("unchecked")
    public static <E extends BaseEntity, D extends DTO> E convertToEntity(D dto) {
        return (E) map.get(dto.getClass().getSimpleName()).convertToEntity(dto);
    }
}
