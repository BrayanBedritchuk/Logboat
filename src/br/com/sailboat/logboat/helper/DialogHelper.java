package br.com.sailboat.logboat.helper;

import javax.swing.JOptionPane;

public class DialogHelper {

	private static final String DEFAULT_ERROR_TITLE = "Error";
	
	private DialogHelper() {
	}
	
	public static void showErrorDialog(Exception exception) {
		showErrorDialog(exception.getMessage());
	}
	
	public static void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(null, message, DEFAULT_ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
	}
}
