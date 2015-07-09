package br.com.netshoes.domain;

import com.squareup.otto.Bus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.netshoes.domain.GetShotsUseCase;
import br.com.netshoes.domain.GetShotsUseCaseController;
import br.com.netshoes.model.DataSource;
import br.com.netshoes.model.responses.ShotsApiResponse;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by douglas on 7/8/15.
 */
public class GetShotsUseCaseTest {
    private GetShotsUseCase mGetShotsUseCase;
    private int page = 1;
    @Mock private DataSource mockDataSource;
    @Mock private Bus mockUiBUs;

    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
        mGetShotsUseCase = new GetShotsUseCaseController(mockDataSource, mockUiBUs, page);
    }

    @Test public void testShotsRequestExecution() {
        mGetShotsUseCase.execute();
        verify(mockDataSource, times(1)).getShots(page);
    }

    @Test public void testUiShotsPost() {
        mGetShotsUseCase.onShotsReceived(any(ShotsApiResponse.class));
        verify(mockUiBUs, times(1)).post(any(ShotsApiResponse.class));
    }

}
