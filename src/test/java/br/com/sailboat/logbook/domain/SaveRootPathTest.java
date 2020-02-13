package br.com.sailboat.logbook.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SaveRootPathTest {

    private SaveRootPath saveRootPath;

    @Mock
    private Repository repository;

    @Before
    public void setUp() {
        saveRootPath = new SaveRootPath(repository);
    }

    @Test
    public void shouldSetRootPathFromRepository() throws IOException {
        saveRootPath.execute("logbook/path");
        verify(repository).saveRootPath("logbook/path");
    }
}