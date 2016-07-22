package com.avlasenko.sb.fmmanager.util.dto.converter;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import ma.glasnost.orika.BoundMapperFacade;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
class IndividualQuickFormCommand implements DTOCommand<Individual, IndividualQuickFormDTO> {
    private BoundMapperFacade<Individual, IndividualQuickFormDTO> facade;

    private static final IndividualQuickFormCommand INSTANCE = new IndividualQuickFormCommand();

    private IndividualQuickFormCommand() {
        mapper.classMap(Individual.class, IndividualQuickFormDTO.class)
                .byDefault()
                .register();
        //need converter for LocalDate
        mapper.getConverterFactory().registerConverter(new LocalDateConverter());
        this.facade = mapper.getMapperFacade(Individual.class, IndividualQuickFormDTO.class);
    }

    static IndividualQuickFormCommand getInstance() {
        return INSTANCE;
    }

    @Override
    public Individual convertToEntity(IndividualQuickFormDTO dto) {
        return facade.mapReverse(dto);
    }
}
