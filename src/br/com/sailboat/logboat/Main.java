package br.com.sailboat.logboat;

import br.com.sailboat.logboat.helper.UIHelper;

public class Main {

	public static void main(String[] args) {
		UIHelper.applySystemLookAndFeel();
		LogboatManager.generateLogboat();
	}

}