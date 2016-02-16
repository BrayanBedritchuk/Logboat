package br.com.sailboat.logboat;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {
		initLookAndFeel();
		generateLogboat();
	}

	private static void initLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"An error occurred while setting the look and feel of the application", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private static void generateLogboat() {
		LogboatManager.generateLogboat();
	}

}