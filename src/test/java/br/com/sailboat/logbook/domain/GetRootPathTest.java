package br.com.sailboat.logbook.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetRootPathTest {

    private GetRootPath getRootPath;

    @Mock
    private Repository repository;

    @Before
    public void setUp() {
        getRootPath = new GetRootPath(repository);
    }

    @Test
    public void shouldGetRootPathFromRepositoryWhenConfigurationExists() throws IOException {
        when(repository.configurationExists()).thenReturn(true);
        getRootPath.execute();
        verify(repository).getRootPath();
    }

    @Test
    public void shouldReturnNullFromGetRootPathWhenConfigurationNotExists() {
        when(repository.configurationExists()).thenReturn(false);
        assertNull(getRootPath.execute());
    }

}