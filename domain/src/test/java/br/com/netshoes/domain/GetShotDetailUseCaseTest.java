package br.com.netshoes.domain;

import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.netshoes.model.DataSource;
import br.com.netshoes.model.responses.ShotDetailApiResponse;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by douglas on 7/8/15.
 */
public class GetShotDetailUseCaseTest {
    private GetShotDetailUseCase mGetShotDetailUseCase;
    private int id = 1757954;
    @Mock private DataSource mockDataSource;
    @Mock private Bus mockUiBUs;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mGetShotDetailUseCase = new GetShotDetailUseCaseController(mockDataSource, mockUiBUs, id);
    }

    @Test
    public void testShotsRequestExecution() {
        mGetShotDetailUseCase.execute();
        verify(mockDataSource, times(1)).getShotDetail(id);
    }

    @Test public void testUiShotsPost() {
        mGetShotDetailUseCase.onShotDetailReceived(any(ShotDetailApiResponse.class));
        verify(mockUiBUs, times(1)).post(any(ShotDetailApiResponse.class));
    }
}
