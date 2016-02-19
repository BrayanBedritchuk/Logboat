package br.com.sailboat.logboat.helper;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooserHelper {
	
	private static final String DEFAULT_APPROVE_BUTTON_TEXT = "Select";
	
	private FileChooserHelper() {
	}
	
	public static JFileChooser getFileChooserFoldersOnly() {
		JFileChooser chooser = new JFileChooser(getDesktopPath());
		chooser.setControlButtonsAreShown(true);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setApproveButtonText(DEFAULT_APPROVE_BUTTON_TEXT);
		chooser.setDialogType(JFileChooser.SAVE_DIALOG);
		return chooser;
	}
	
	private static String getDesktopPath() {
		return (System.getProperty("user.home") + File.separator + "Desktop");
	}
}
