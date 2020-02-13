package br.com.sailboat.logbook.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LogbookTest {

    private Logbook logbook;

    @Before
    public void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 6);

        logbook = new Logbook(calendar.getTime(), Locale.ENGLISH);
    }

    @Test
    public void shouldGetYearSuccessfully() {
        assertThat(logbook.getYear(), is("2020"));
    }

    @Test
    public void shouldGetMonthSuccessfully() {
        assertThat(logbook.getMonth(), is("02 - February"));
    }

    @Test
    public void shouldGetDaySuccessfully() {
        assertThat(logbook.getDay(), is("06-02-2020 (37)"));
    }

}