package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingGameView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RacingGameInitializerTest {
    private RacingGameView view;

    @BeforeEach
    void setup(){
        view = mock(RacingGameView.class);
    }

    @Test
    public void returnRacingGameWhenInitialized() {
        int carCount = 3;
        int attempts = 5;
        when(view.getCarCount()).thenReturn(carCount);
        when(view.getAttemptCount()).thenReturn(attempts);

        RacingGameInitializer initializer = new RacingGameInitializer(view);

        RacingGame racingGame = initializer.init();

        assertNotNull(racingGame);
        assertThat(racingGame.getCars()).hasSize(carCount);
        assertThat(racingGame.getAttempts()).isEqualTo(attempts);
    }
}
