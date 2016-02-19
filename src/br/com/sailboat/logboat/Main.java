package br.com.sailboat.logboat;

import br.com.sailboat.logboat.helper.UiHelper;

public class Main {

	public static void main(String[] args) {
		applySystemLookAndFeel();
		generateLogboat();
	}

	private static void applySystemLookAndFeel() {
		UiHelper.applySystemLookAndFeel();
	}

	private static void generateLogboat() {
		LogboatManager.generateLogboat();
	}

}