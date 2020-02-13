package br.com.sailboat.logbook.ui;

import javax.swing.*;

public class DialogHelper {

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
