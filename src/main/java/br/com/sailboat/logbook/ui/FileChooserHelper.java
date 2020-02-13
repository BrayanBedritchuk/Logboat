package br.com.sailboat.logbook.ui;

import javax.swing.*;
import java.io.File;

public class FileChooserHelper {

    public static JFileChooser getFolderChooser() {
        JFileChooser chooser = new JFileChooser(getDesktopPath());
        chooser.setControlButtonsAreShown(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        return chooser;
    }

    private static String getDesktopPath() {
        return (System.getProperty("user.home") + File.separator + "Desktop");
    }

}
