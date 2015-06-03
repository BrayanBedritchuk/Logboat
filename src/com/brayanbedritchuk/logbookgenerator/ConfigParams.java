package com.brayanbedritchuk.logbookgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ConfigParams {

	private static final String LOGBOOK_FILE_TYPE = ".txt";
	private static final String LOGBOOK_DATE_PATTERN = "dd-MM-yyyy (D)";
	private static final String LOGBOOK_MONTH_PATTERN = "MM - MMMMMMMMMMMMMMM";

	private String directoryPath;
	private String directoryName;
	
	private Calendar currentCalendar;
	
	private SimpleDateFormat formatLogbookDate;
	private SimpleDateFormat formatLogbookMonth;

	public ConfigParams(Calendar currentCalendar) {
		this.currentCalendar = currentCalendar;
		this.formatLogbookDate = new SimpleDateFormat(LOGBOOK_DATE_PATTERN, Locale.getDefault());
		this.formatLogbookMonth = new SimpleDateFormat(LOGBOOK_MONTH_PATTERN, Locale.getDefault());
	}

	public String getTextFilePath() throws FileNotFoundException {
		return (getMonthDirectoryPath() + File.separator + getFileName() + LOGBOOK_FILE_TYPE);
	}

	private String getFileName() {
		return formatLogbookDate.format(currentCalendar.getTime());
	}

	public String getMonthDirectoryPath() throws FileNotFoundException {
		return (getLogbookDirectoryPath() + File.separator + getMonthDirectoryName());
	}

	private String getMonthDirectoryName() {
		return formatLogbookMonth.format(currentCalendar.getTime());
	}

	public String getLogbookDirectoryPath() throws FileNotFoundException {
		return directoryPath + File.separator + directoryName;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

}
