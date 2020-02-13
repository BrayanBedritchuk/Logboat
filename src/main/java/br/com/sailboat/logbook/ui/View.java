package br.com.sailboat.logbook.ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class View implements LogbookContract.View {

    public View() {
        applySystemLookAndFeel();
    }

    @Override
    public Date getLogbookDate() {
        return new Date();
    }

    @Override
    public String getRootPath() {
        JFileChooser chooser = FileChooserHelper.getFolderChooser();
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getAbsolutePath();
        }
        System.exit(0);
        return null;
    }

    @Override
    public void logError(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void showErrorMessage() {
        DialogHelper.showError("Logbook could not be displayed :/");
    }

    @Override
    public void showLogbook(String path) {
        try {
            File logbook = new File(path);
            Desktop.getDesktop().open(logbook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void applySystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
