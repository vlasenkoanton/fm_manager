package com.avlasenko.sb.fmmanager.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author A. Vlasenko
 * 09.06.2016
 *
 */
public abstract class DateTimeUtils {
	private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");
	private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
	
	public static String toString(LocalDate localDate) {
		return localDate.format(DATE_FORMATTER);
	}

	public static String toString(LocalDateTime localDateTime) {
		return localDateTime.format(DATE_TIME_FORMATTER);
	}

	public static LocalDate toLocalDate(String s) {
		return LocalDate.parse(s, DATE_FORMATTER);
	}

	public static LocalDateTime toLocalDateTime(String s) {
		return LocalDateTime.parse(s, DATE_TIME_FORMATTER);
	}
}
