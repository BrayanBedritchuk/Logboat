package br.com.sailboat.logbook.data;

import br.com.sailboat.logbook.domain.Logbook;
import br.com.sailboat.logbook.domain.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class RepositoryImpl implements Repository {

    private ConfigurationData configurationData;
    private Locale locale;

    public RepositoryImpl() {
        this.configurationData = new ConfigurationData();
        this.locale = Locale.ENGLISH;
    }

    @Override
    public boolean configurationExists() {
        return this.configurationData.getFile().exists();
    }

    @Override
    public boolean logbookExists(Date date) {
        try {
            return new File(getLogbookPath(date)).exists();
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String createLogbook(Date date) throws IOException {
        new File(getMonthPath(date)).mkdirs();
        String path = getLogbookPath(date);
        TextFileHelper.createFile(path, null);
        return path;
    }

    @Override
    public String getLogbookPath(Date date) throws IOException {
        Logbook logbook = new Logbook(date, this.locale);
        return LogbookData.getFullPath(getRootPath(), logbook);
    }

    @Override
    public void saveRootPath(String path) throws IOException {
        TextFileHelper.createFile(ConfigurationData.CONFIG_FILE_NAME, path);
    }

    @Override
    public String getRootPath() throws IOException {
        return TextFileHelper.getFirstLineFromTextFile(configurationData.getFile());
    }

    private String getMonthPath(Date date) throws IOException {
        Logbook logbook = new Logbook(date, this.locale);
        return LogbookData.getMonthPath(getRootPath(), logbook);
    }

}
