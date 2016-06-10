package com.avlasenko.sb.fmmanager.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author A. Vlasenko
 * 09.06.2016
 *
 */
public abstract class TimeUtil {
	private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	public static String dateToString(LocalDate localDate) {
		return localDate.format(DATE_FORMATTER);
	}
}
