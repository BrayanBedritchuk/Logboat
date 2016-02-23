package br.com.sailboat.logboat;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogboatParams {

	public static final String FOLDER_NAME = "Logboat";

	private static final String FILE_TYPE = ".txt";
	private static final String DATE_PATTERN = "dd-MM-yyyy (DD)";
	private static final String MONTH_PATTERN = "MM - MMMMMMMMMMMMMMM";
	private static final String YEAR_PATTERN = "yyyy";

	private LogboatParams() {
	}

	public static String getTextFilePath(String rootPath) throws FileNotFoundException {
		StringBuilder path = new StringBuilder();
		path.append(getMonthFolderPath(rootPath));
		path.append(File.separator);
		path.append(getFileName());
		path.append(FILE_TYPE);
		
		return path.toString();
	}

	public static String getMonthFolderPath(String rootPath) throws FileNotFoundException {
		StringBuilder path = new StringBuilder();
		path.append(getLogboatFolderPath(rootPath));
		path.append(File.separator);
		path.append(getYearFolderName());
		path.append(File.separator);
		path.append(getMonthFolderName());
		
		return path.toString();
	}

	public static String getLogboatFolderPath(String rootPath) throws FileNotFoundException {
		StringBuilder path = new StringBuilder();
		path.append(rootPath);
		path.append(File.separator);
		path.append(FOLDER_NAME);
		
		return path.toString();
	}
	
	private static String getFileName() {
		return new SimpleDateFormat(DATE_PATTERN).format(getCurrentDate());
	}
	
	private static String getMonthFolderName() {
		return new SimpleDateFormat(MONTH_PATTERN).format(getCurrentDate());
	}

	private static String getYearFolderName() {
		return new SimpleDateFormat(YEAR_PATTERN).format(getCurrentDate());
	}
	
	private static Date getCurrentDate() {
		return new Date();
	}

}
