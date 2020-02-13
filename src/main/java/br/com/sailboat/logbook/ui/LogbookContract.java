package br.com.sailboat.logbook.ui;

import java.util.Date;

public interface LogbookContract {

    interface View {
        Date getLogbookDate();
        String getRootPath();
        void logError(Exception e);
        void showErrorMessage();
        void showLogbook(String path);
    }

    interface Presenter {
        void start();
    }

}
