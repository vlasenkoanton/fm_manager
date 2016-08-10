package com.avlasenko.sb.fmmanager.util.dto.converter;

import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.util.dto.IndividualQuickFormDTO;
import ma.glasnost.orika.*;
import ma.glasnost.orika.metadata.Type;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
class IndividualQuickFormCommand implements DTOCommand<Individual, IndividualQuickFormDTO> {
    private BoundMapperFacade<Individual, IndividualQuickFormDTO> facade;

    private static final IndividualQuickFormCommand INSTANCE = new IndividualQuickFormCommand();

    private IndividualQuickFormCommand() {
        mapper.classMap(Individual.class, IndividualQuickFormDTO.class)
                .byDefault()
                .customize(new CustomMapper<Individual, IndividualQuickFormDTO>(){
                    @Override
                    public void mapBtoA(IndividualQuickFormDTO quickFormDTO, Individual individual, MappingContext context) {
                        Set<Document> set = new HashSet<>();
                        set.add(quickFormDTO.getDocument());
                        individual.setDocuments(set);
                    }
                })
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
