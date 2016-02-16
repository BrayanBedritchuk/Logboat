package br.com.sailboat.logboat;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ConfigParams {

	public static final String DIRECTORY_NAME = "Logboat";

	private static final String LOGBOAT_FILE_TYPE = ".txt";
	private static final String LOGBOAT_DATE_PATTERN = "dd-MM-yyyy (DD)";
	private static final String LOGBOAT_MONTH_PATTERN = "MM - MMMMMMMMMMMMMMM";
	private static final String LOGBOAT_YEAR_PATTERN = "yyyy";

	private String directoryPath;

	private Calendar currentCalendar;

	private SimpleDateFormat formatLogbookDate;
	private SimpleDateFormat formatLogbookMonth;
	private SimpleDateFormat formatLogbookYear;

	public ConfigParams(Calendar currentCalendar) {
		this.currentCalendar = currentCalendar;
		this.formatLogbookDate = new SimpleDateFormat(LOGBOAT_DATE_PATTERN, Locale.getDefault());
		this.formatLogbookMonth = new SimpleDateFormat(LOGBOAT_MONTH_PATTERN, Locale.getDefault());
		this.formatLogbookYear = new SimpleDateFormat(LOGBOAT_YEAR_PATTERN, Locale.getDefault());
	}

	public String getTextFilePath() throws FileNotFoundException {
		return (getMonthDirectoryPath() + File.separator + getFileName() + LOGBOAT_FILE_TYPE);
	}

	private String getFileName() {
		return formatLogbookDate.format(currentCalendar.getTime());
	}

	public String getMonthDirectoryPath() throws FileNotFoundException {
		return (getLogbookDirectoryPath() + File.separator + getYearDirectoryName() + File.separator
				+ getMonthDirectoryName());
	}

	private String getMonthDirectoryName() {
		return formatLogbookMonth.format(currentCalendar.getTime());
	}

	private String getYearDirectoryName() {
		return formatLogbookYear.format(currentCalendar.getTime());
	}

	public String getLogbookDirectoryPath() throws FileNotFoundException {
		return directoryPath + File.separator + DIRECTORY_NAME;
	}

	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

}
