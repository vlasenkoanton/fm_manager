package com.avlasenko.sb.fmmanager.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
public class LocalDatePropertyConverter extends PropertyEditorSupport {
    private DateTimeFormatter dateTimeFormatter;

    public LocalDatePropertyConverter(String pattern) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String getAsText() {
        Object o = this.getValue();
        if (o == null) {
            return "";
        }
        return dateTimeFormatter.format((LocalDate) o);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            this.setValue(null);
        } else {
            LocalDate localDate = LocalDate.parse(text, dateTimeFormatter);
            this.setValue(localDate);
        }
    }
}
