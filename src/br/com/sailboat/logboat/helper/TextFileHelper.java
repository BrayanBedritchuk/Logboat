package br.com.sailboat.logboat.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TextFileHelper {

	public static final String DEFAULT_ENCODING = "UTF-8";

	private TextFileHelper() {
	}

	public static void createTextFile(String path) throws FileNotFoundException, UnsupportedEncodingException {

		createTextFileWithContent(path, null);
	}

	public static void createTextFileWithContent(String path, String content)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter(path, DEFAULT_ENCODING);
		if (isValid(content)) {
			writer.append(content);
		}
		writer.close();
	}

	public static String getFirstNonEmptyLineFromTextFile(File file) throws Exception {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				if (isValid(line)) {
					reader.close();
					return line;
				}
				line = reader.readLine();
			}
			reader.close();
			return line;
		} catch (Exception e) {
			reader.close();
			throw e;
		}
	}

	private static boolean isValid(String text) {
		return text != null && !text.trim().isEmpty();
	}
}
