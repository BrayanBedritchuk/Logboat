package br.com.sailboat.logbook.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetLogbookPathTest {

    private GetLogbookPath getLogbookPath;
    private Date date;

    @Mock
    private Repository repository;

    @Before
    public void setUp() {
        getLogbookPath = new GetLogbookPath(repository);
        date = new Date();
    }

    @Test
    public void shouldGetLogbookPathFromRepositoryWhenLogbookExists() throws IOException {
        when(repository.logbookExists(date)).thenReturn(true);
        when(repository.getLogbookPath(date)).thenReturn("logbook/path");
        assertThat(getLogbookPath.execute(date), is("logbook/path"));
    }

    @Test
    public void shouldReturnNullFromGetLogbookPathWhenLogbookNotExists() throws IOException {
        when(repository.logbookExists(date)).thenReturn(false);
        assertNull(getLogbookPath.execute(date));
    }

}