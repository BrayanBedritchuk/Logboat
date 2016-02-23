package br.com.sailboat.logboat;

import javax.swing.UIManager;

import br.com.sailboat.logboat.helper.DialogHelper;

public class Main {

	public static void main(String[] args) {
		applySystemLookAndFeel();
		generateLogboat();
	}

	private static void applySystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			DialogHelper.showErrorDialog("An error occurred while setting the look and feel of the application");
		}
	}

	private static void generateLogboat() {
		LogboatManager.generateLogboat();
	}

}