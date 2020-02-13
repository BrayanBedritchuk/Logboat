package br.com.sailboat.logbook.domain;

import java.io.IOException;
import java.util.Date;

public class GetLogbookPath {

    private Repository repository;

    public GetLogbookPath(Repository repository) {
        this.repository = repository;
    }

    public String execute(Date date) throws IOException {
        if (repository.logbookExists(date)) {
            return repository.getLogbookPath(date);
        }
        return null;
    }

}
