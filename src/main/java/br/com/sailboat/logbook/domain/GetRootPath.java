package br.com.sailboat.logbook.domain;

import java.io.IOException;

public class GetRootPath {

    private Repository repository;

    public GetRootPath(Repository repository) {
        this.repository = repository;
    }

    public String execute() {
        try {
            if (repository.configurationExists()) {
                return repository.getRootPath();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

}
