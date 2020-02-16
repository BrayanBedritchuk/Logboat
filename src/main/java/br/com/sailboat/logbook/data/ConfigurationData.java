package br.com.sailboat.logbook.data;

import java.io.File;

public class ConfigurationData {

    public static final String CONFIG_FILE_NAME = "config.txt";
    private File configFile;

    public ConfigurationData() {
        this.configFile = new File(CONFIG_FILE_NAME);
    }

    public File getFile() {
        return this.configFile;
    }

}
