package br.com.sailboat.logboat;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LogboatManager {

	private static final String CONFIG_FILE_NAME = "config.txt";

	private ConfigParams configParams;

	private LogboatManager() {
	}

	public static void generateLogboat() {
		new LogboatManager().generate();
	}

	private void generate() {
		try {
			initConfigParams();
			initMonthDirectory();
			initTextFile();
		} catch (FileChooserCanceledException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			showErrorMessage(e.getMessage());
		}
	}

	private void initConfigParams() throws Exception {
		File file = new File(CONFIG_FILE_NAME);

		if (!file.exists()) {
			showFileChooserAndCreateConfigurationFile();
		}

		String path = getPathFromConfigurationFile(file);
		createConfigParams(path);
	}

	private void showFileChooserAndCreateConfigurationFile()
			throws FileChooserCanceledException, FileNotFoundException, UnsupportedEncodingException {
		JFileChooser chooser = buildFileChooser();
		
		int returnValue = chooser.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String absolutePath = chooser.getSelectedFile().getAbsolutePath();
			createNewTextFile(CONFIG_FILE_NAME, absolutePath);
		} else {
			throw new FileChooserCanceledException();
		}
	}

	private JFileChooser buildFileChooser() {
		JFileChooser chooser = new JFileChooser(getInitialFileChooserPath());
		chooser.setControlButtonsAreShown(true);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setApproveButtonText("Select");
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		return chooser;
	}

	private static String getInitialFileChooserPath() {
		return (System.getProperty("user.home") + File.separator + "Desktop");
	}

	private String getPathFromConfigurationFile(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			String line = reader.readLine();
			while (line != null) {

				if (!line.trim().isEmpty()) {
					return line;
				}

				line = reader.readLine();
			}
		} finally {
			reader.close();
		}
		return null;
	}

	private void createConfigParams(String path) {
		Calendar c = Calendar.getInstance();
		configParams = new ConfigParams(c);
		configParams.setDirectoryPath(path);
	}

	private void initMonthDirectory() throws Exception {
		File monthDirectory = new File(configParams.getMonthDirectoryPath());
		if (!monthDirectory.exists()) {
			monthDirectory.mkdirs();
		}
	}

	private void initTextFile() throws Exception {
		try {
			File textFile = new File(configParams.getTextFilePath());
			if (!textFile.exists()) {
				createNewTextFile(configParams.getTextFilePath());
			}
			openFile(textFile);
		} catch (Exception e) {
			throw new Exception("An error occurred while initializing the logbook text file. " + e.getMessage(), e);
		}
	}

	private void createNewTextFile(String path, String text)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		
		if (isValid(text)) {
			writer.append(text);
		}
		writer.close();
	}

	private boolean isValid(String text) {
		return text != null && !text.trim().isEmpty();
	}

	private void createNewTextFile(String path) throws FileNotFoundException, UnsupportedEncodingException {
		createNewTextFile(path, null);
	}

	private void openFile(File textFile) throws IOException {
		Desktop.getDesktop().open(textFile);
	}

	private void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
