package br.com.sailboat.logbook.domain;

import java.io.IOException;
import java.util.Date;

public interface Repository {
    boolean configurationExists();
    boolean logbookExists(Date date);
    String createLogbook(Date date) throws IOException;
    String getLogbookPath(Date date) throws IOException;
    String getRootPath() throws IOException;
    void saveRootPath(String path) throws IOException;
}
