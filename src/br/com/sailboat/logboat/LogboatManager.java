package br.com.sailboat.logboat;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFileChooser;

import br.com.sailboat.logboat.helper.DialogHelper;
import br.com.sailboat.logboat.helper.FileChooserHelper;
import br.com.sailboat.logboat.helper.TextFileHelper;

public class LogboatManager {

	private static final String CONFIG_FILE_NAME = "config.txt";

	private String rootPath;

	private LogboatManager() {
	}

	public static void generateLogboat() {
		new LogboatManager().generate();
	}

	private void generate() {
		try {
			initRootPath();
			initMonthFolder();
			initTextFile();
		} catch (FileChooserCanceledException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			showErrorDialog(e);
		}
	}

	private void initRootPath() throws Exception {
		File file = new File(CONFIG_FILE_NAME);
		if (!file.exists()) {
			showFileChooserAndCreateConfigurationFile();
		}
		setRootPath(getPathFromConfigurationFile(file));
	}
	
	private void initMonthFolder() throws Exception {
		File monthFolder = new File(getMonthFolderPath());
		if (!monthFolder.exists()) {
			monthFolder.mkdirs();
		}
	}
	
	private void initTextFile() throws Exception {
		try {
			File textFile = new File(getTextFilePath());
			if (!textFile.exists()) {
				createNewTextFile(getTextFilePath(), null);
			}
			openFile(textFile);
		} catch (Exception e) {
			throw new Exception("An error occurred while initializing the logbook text file. " + e.getMessage(), e);
		}
	}

	private String getTextFilePath() throws FileNotFoundException {
		return LogboatParams.getTextFilePath(getRootPath());
	}

	private String getPathFromConfigurationFile(File file) throws Exception {
		return TextFileHelper.getFirstNonEmptyLineFromTextFile(file);
	}

	private String getMonthFolderPath() throws FileNotFoundException {
		return LogboatParams.getMonthFolderPath(getRootPath());
	}

	private void openFile(File textFile) throws IOException {
		Desktop.getDesktop().open(textFile);
	}

	private void showErrorDialog(Exception exception) {
		DialogHelper.showErrorDialog(exception);
	}
	
	private void showFileChooserAndCreateConfigurationFile()
			throws FileChooserCanceledException, FileNotFoundException, UnsupportedEncodingException {
		JFileChooser chooser = getFileChooserFoldersOnly();
		
		int returnValue = chooser.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String absolutePath = chooser.getSelectedFile().getAbsolutePath();
			createNewTextFile(CONFIG_FILE_NAME, absolutePath);
		} else {
			throw new FileChooserCanceledException();
		}
	}
	
	private void createNewTextFile(String path, String content)
			throws FileNotFoundException, UnsupportedEncodingException {
		
		TextFileHelper.createTextFileWithContent(path, content);
	}

	private JFileChooser getFileChooserFoldersOnly() {
		return FileChooserHelper.getFileChooserFoldersOnly();
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

}
