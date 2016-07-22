package com.avlasenko.sb.fmmanager.util.dto.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;

/**
 * Created by A. Vlasenko on 21.07.2016.
 */
class LocalDateConverter extends BidirectionalConverter<LocalDate, LocalDate> {
    @Override
    public LocalDate convertTo(LocalDate source, Type<LocalDate> destinationType) {
        return LocalDate.from(source);
    }

    @Override
    public LocalDate convertFrom(LocalDate source, Type<LocalDate> destinationType) {
        return LocalDate.from(source);
    }
}
