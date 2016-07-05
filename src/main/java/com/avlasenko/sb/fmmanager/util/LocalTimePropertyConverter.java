package com.avlasenko.sb.fmmanager.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by A. Vlasenko on 26.06.2016.
 */
public class LocalTimePropertyConverter extends PropertyEditorSupport {
    private DateTimeFormatter dateTimeFormatter;

    public LocalTimePropertyConverter(String pattern) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public String getAsText() {
        LocalDate localDate = (LocalDate) this.getValue();
        if (localDate == null) {
            return "";
        }
        return dateTimeFormatter.format(localDate);
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
