package br.com.sailboat.logbook.domain;

import java.io.IOException;

public class SaveRootPath {

    private Repository repository;

    public SaveRootPath(Repository repository) {
        this.repository = repository;
    }

    public void execute(String path) throws IOException {
        repository.saveRootPath(path);
    }

}
