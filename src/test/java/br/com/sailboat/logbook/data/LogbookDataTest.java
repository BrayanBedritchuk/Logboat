package br.com.sailboat.logbook.data;

import br.com.sailboat.logbook.domain.Logbook;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Calendar;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LogbookDataTest {

    private Logbook logbook;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 13);

        logbook = new Logbook(calendar.getTime(), Locale.ENGLISH);
    }

    @Test
    public void shouldGetMothPathSuccessfully() {
        String monthPath = LogbookData.getMonthPath("root" + File.separator + "path", logbook);
        String result = "root" + File.separator +
                "path" + File.separator +
                "logbook" + File.separator +
                "2020" + File.separator +
                "02 - February";
        assertThat(monthPath, is(result));
    }

    @Test
    public void shouldGetFullPathSuccessfully() {
        String fullPath = LogbookData.getFullPath("root" + File.separator + "path", logbook);
        String result = "root" + File.separator +
                "path" + File.separator +
                "logbook" + File.separator +
                "2020" + File.separator +
                "02 - February" + File.separator +
                "13-02-2020 (44).txt";
        assertThat(fullPath, is(result));
    }

}