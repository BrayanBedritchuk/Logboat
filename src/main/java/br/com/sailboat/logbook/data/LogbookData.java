package br.com.sailboat.logbook.data;

import br.com.sailboat.logbook.domain.Logbook;

import java.io.File;

public class LogbookData {

    private static final String FOLDER_NAME = "logbook";
    private static final String FILE_TYPE = ".txt";

    public static String getFullPath(String rootPath, Logbook logbook) {
        return getMonthPath(rootPath, logbook) + File.separator +
                logbook.getDay() + FILE_TYPE;
    }

    public static String getMonthPath(String rootPath, Logbook logbook) {
        return rootPath + File.separator + FOLDER_NAME + File.separator +
                logbook.getYear() + File.separator + logbook.getMonth();
    }

}
