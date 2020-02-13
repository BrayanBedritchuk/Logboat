package br.com.sailboat.logbook.ui;

import br.com.sailboat.logbook.domain.CreateLogbook;
import br.com.sailboat.logbook.domain.GetLogbookPath;
import br.com.sailboat.logbook.domain.GetRootPath;
import br.com.sailboat.logbook.domain.SaveRootPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    private Presenter presenter;
    private Date date;

    @Mock
    private CreateLogbook createLogbook;

    @Mock
    private GetLogbookPath getLogbookPath;

    @Mock
    private GetRootPath getRootPath;

    @Mock
    private SaveRootPath saveRootPath;

    @Mock
    private LogbookContract.View view;

    @Before
    public void setUp() {
        presenter = new Presenter(createLogbook, getLogbookPath, getRootPath, saveRootPath, view);
        date = new Date();
    }

    @Test
    public void shouldGetRootPathFromViewWhenGetRootPathFromDomainReturnsNull() {
        when(getRootPath.execute()).thenReturn(null);
        presenter.start();
        verify(view).getRootPath();
    }

    @Test
    public void shouldShowErrorMessageWhenGetRootPathThrowsAnException() {
        when(getRootPath.execute()).thenThrow(RuntimeException.class);
        presenter.start();
        verify(view).showErrorMessage();
    }

    @Test
    public void shouldSetRootPathFromViewWhenGetRootPathFomDomainReturnsNull() throws IOException {
        when(getRootPath.execute()).thenReturn(null);
        when(view.getRootPath()).thenReturn("my/path");
        presenter.start();
        verify(saveRootPath).execute("my/path");
    }

    @Test
    public void shouldShowErrorMessageWhenSetRootPathThrowsAnException() throws IOException {
        when(getRootPath.execute()).thenReturn(null);
        when(view.getRootPath()).thenReturn("my/path");
        doThrow(RuntimeException.class).when(saveRootPath).execute("my/path");
        presenter.start();
        verify(view).showErrorMessage();
    }

    @Test
    public void shouldNotGetRootPathFromViewWhenGetRootPathFromDomainReturnsPath() {
        when(getRootPath.execute()).thenReturn("my/path");
        presenter.start();
        verify(view, times(0)).getRootPath();
    }

    @Test
    public void shouldNotSetRootPathWhenGetRootPathFromDomainReturnsPath() {
        when(getRootPath.execute()).thenReturn("my/path");
        presenter.start();
        verifyNoInteractions(saveRootPath);
    }

    @Test
    public void shouldCreateLogbookWhenGetLogbookPathReturnsNull() throws IOException {
        when(view.getLogbookDate()).thenReturn(date);
        when(getLogbookPath.execute(date)).thenReturn(null);
        presenter.start();
        verify(createLogbook).execute(date);
    }

    @Test
    public void shouldNotCreateLogbookWhenGetLogbookPathReturnsPath() throws IOException {
        when(view.getLogbookDate()).thenReturn(date);
        when(getLogbookPath.execute(date)).thenReturn("my/path");
        presenter.start();
        verifyNoInteractions(createLogbook);
    }

    @Test
    public void shouldGetLogbookPathWhenGetLogbookPathReturnsPath() throws IOException {
        when(view.getLogbookDate()).thenReturn(date);
        when(getRootPath.execute()).thenReturn("root/path");
        presenter.start();
        verify(getLogbookPath).execute(date);
    }

    @Test
    public void shouldShowLogbookWhenGetLogbookPathReturnsPath() throws IOException {
        when(view.getLogbookDate()).thenReturn(date);
        when(getLogbookPath.execute(date)).thenReturn("my/logbook/path");
        presenter.start();
        verify(view).showLogbook("my/logbook/path");
    }

    @Test
    public void shouldShowLogbookWhenCreateLogbookReturnsPath() throws IOException {
        when(view.getLogbookDate()).thenReturn(date);
        when(getLogbookPath.execute(date)).thenReturn(null);
        when(createLogbook.execute(date)).thenReturn("my/path");
        presenter.start();
        verify(view).showLogbook("my/path");
    }

}