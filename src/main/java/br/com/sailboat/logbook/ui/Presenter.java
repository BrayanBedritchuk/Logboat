package br.com.sailboat.logbook.ui;

import br.com.sailboat.logbook.domain.CreateLogbook;
import br.com.sailboat.logbook.domain.GetLogbookPath;
import br.com.sailboat.logbook.domain.GetRootPath;
import br.com.sailboat.logbook.domain.SaveRootPath;

import java.io.IOException;
import java.util.Date;

public class Presenter implements LogbookContract.Presenter {

    private CreateLogbook createLogbook;
    private GetLogbookPath getLogbookPath;
    private GetRootPath getRootPath;
    private SaveRootPath saveRootPath;
    private LogbookContract.View view;

    public Presenter(CreateLogbook createLogbook,
                     GetLogbookPath getLogbookPath,
                     GetRootPath getRootPath,
                     SaveRootPath saveRootPath,
                     LogbookContract.View view) {
        this.createLogbook = createLogbook;
        this.getLogbookPath = getLogbookPath;
        this.getRootPath = getRootPath;
        this.saveRootPath = saveRootPath;
        this.view = view;
    }

    @Override
    public void start() {
        try {
            setUpRootPathIfNeeded();
            showLogbook();
        } catch (Exception e) {
            view.logError(e);
            view.showErrorMessage();
        }
    }

    private void setUpRootPathIfNeeded() throws IOException {
        if (getRootPath.execute() == null) {
            String path = view.getRootPath();
            saveRootPath.execute(path);
        }
    }

    private void showLogbook() throws IOException {
        Date date = view.getLogbookDate();
        String path = getLogbookPath.execute(date);
        if (path == null) {
            path = createLogbook.execute(date);
        }
        view.showLogbook(path);
    }

}
