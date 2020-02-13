package br.com.sailboat.logbook.data;

import br.com.sailboat.logbook.domain.Logbook;
import org.junit.Before;
import org.junit.Test;

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
        String monthPath = LogbookData.getMonthPath("root\\path", logbook);
        assertThat(monthPath, is("root\\path\\logbook\\2020\\02 - February"));
    }

    @Test
    public void shouldGetFullPathSuccessfully() {
        String fullPath = LogbookData.getFullPath("root\\path", logbook);
        assertThat(fullPath, is("root\\path\\logbook\\2020\\02 - February\\13-02-2020 (44).txt"));
    }

}