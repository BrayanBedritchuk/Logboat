package br.com.sailboat.logbook.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CreateLogbookTest {

    private CreateLogbook createLogbook;

    @Mock
    private Repository repository;

    @Before
    public void setUp() {
        createLogbook = new CreateLogbook(repository);
    }

    @Test
    public void shouldCreateLogbookFromRepository() throws IOException {
        Date date = new Date();
        createLogbook.execute(date);
        verify(repository).createLogbook(date);
    }

}