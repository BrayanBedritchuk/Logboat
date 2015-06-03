package com.brayanbedritchuk.logbookgenerator;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

public class LogbookGenerator {

	private static final String CONFIG_FILE_NAME = "config.txt";

	private ConfigParams configParams;

	public void generate() {
		try {
			initConfigParams();
			initLogbookDirectory();
			initMonthDirectory();
			initTextFile();
		} catch (Exception e) {
			e.printStackTrace();
			showErrorMessage(e.getMessage());
		}
	}

	private void initConfigParams() throws Exception {
		try {
			File file = new File(CONFIG_FILE_NAME);

			if (!file.exists()) {
				throw new FileNotFoundException("Configuration file not found");
			}

			List<String> listConfigFile = getConfigurationFileLines(file);

			if (listConfigFile.isEmpty()) {
				throw new Exception("The config.txt file does not contain the correct parameters");
			}

			createConfigParams(listConfigFile);

		} catch (Exception e) {
			throw new Exception(
					"An error occurred while initializing the configuration parameters. "
							+ e.getMessage(), e);
		}
	}

	private List<String> getConfigurationFileLines(File file) throws Exception {

		List<String> listConfigFile = new ArrayList<String>();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			String line = reader.readLine();

			while (line != null) {
				listConfigFile.add(line);
				line = reader.readLine();
			}
		} finally {
			reader.close();
		}
		return listConfigFile;
	}

	private void createConfigParams(List<String> listConfigFile) {
		Calendar c = Calendar.getInstance();
		configParams = new ConfigParams(c);
		configParams.setDirectoryName(listConfigFile.get(0));
		configParams.setDirectoryPath(listConfigFile.get(1));
	}

	private void initLogbookDirectory() throws Exception {
		try {
			File logbookDirectory = new File(configParams.getLogbookDirectoryPath());

			if (!logbookDirectory.exists()) {
				logbookDirectory.mkdir();
			}
		} catch (Exception e) {
			throw new Exception(
					"An error occurred while initializing the main directory of the Logbook. "
							+ e.getMessage(), e);
		}
	}

	private void initMonthDirectory() throws Exception {
		try {
			File monthDirectory = new File(configParams.getMonthDirectoryPath());

			if (!monthDirectory.exists()) {
				monthDirectory.mkdir();
			}
		} catch (Exception e) {
			throw new Exception(
					"An error occurred while initializing the directory related to the current month. "
							+ e.getMessage(), e);
		}
	}

	private void initTextFile() throws Exception {
		try {
			File textFile = new File(configParams.getTextFilePath());

			if (!textFile.exists()) {
				createNewTextFile();
			}

			openFile(textFile);

		} catch (Exception e) {
			throw new Exception("An error occurred while initializing the logbook text file. "
					+ e.getMessage(), e);
		}
	}

	private void createNewTextFile() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(configParams.getTextFilePath(), "UTF-8");
		writer.close();
	}

	private void openFile(File textFile) throws IOException {
		Desktop.getDesktop().open(textFile);
	}

	private void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
