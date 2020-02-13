package br.com.sailboat.logbook.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logbook {

    private static final String YEAR_PATTERN = "yyyy";
    private static final String MONTH_PATTERN = "MM - MMMMMMMMMMMMMMM";
    private static final String DATE_PATTERN = "dd-MM-yyyy (DD)";

    private Date date;
    private Locale locale;

    public Logbook(Date date, Locale locale) {
        this.date = date;
        this.locale = locale;
    }

    public String getYear() {
        return new SimpleDateFormat(YEAR_PATTERN, locale).format(this.date);
    }

    public String getMonth() {
        return new SimpleDateFormat(MONTH_PATTERN, locale).format(this.date);
    }

    public String getDay() {
        return new SimpleDateFormat(DATE_PATTERN, locale).format(this.date);
    }

}
