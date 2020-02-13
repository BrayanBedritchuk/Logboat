package br.com.sailboat.logbook.domain;

import java.io.IOException;
import java.util.Date;

public class CreateLogbook {

    private Repository repository;

    public CreateLogbook(Repository repository) {
        this.repository = repository;
    }

    public String execute(Date date) throws IOException {
        return repository.createLogbook(date);
    }

}
