package br.com.sailboat.logbook;

import br.com.sailboat.logbook.data.RepositoryImpl;
import br.com.sailboat.logbook.domain.*;
import br.com.sailboat.logbook.ui.Presenter;
import br.com.sailboat.logbook.ui.View;

public class Main {

    public static void main(String[] args) {
        Repository repository = new RepositoryImpl();
        new Presenter(
                new CreateLogbook(repository),
                new GetLogbookPath(repository),
                new GetRootPath(repository),
                new SaveRootPath(repository),
                new View()
        ).start();
    }

}
