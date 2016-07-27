package com.avlasenko.sb.fmmanager.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by A. Vlasenko on 27.07.2016.
 */
public class LocalDateTimePropertyConverter extends PropertyEditorSupport {

    private DateTimeFormatter dateTimeFormatter;

    public LocalDateTimePropertyConverter(String pattern) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String getAsText() {
        Object o = this.getValue();
        if (o == null) {
            return "";
        }
        return dateTimeFormatter.format((LocalDateTime) o);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            this.setValue(null);
        } else {
            LocalDateTime localDateTime = LocalDateTime.parse(text, dateTimeFormatter);
            this.setValue(localDateTime);
        }
    }
}
