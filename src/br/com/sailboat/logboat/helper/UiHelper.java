package br.com.sailboat.logboat.helper;

import javax.swing.UIManager;

public class UiHelper {

	private UiHelper() {
	}
	
	public static void applySystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			DialogHelper.showErrorDialog("An error occurred while setting the look and feel of the application");
		}
	}
}
