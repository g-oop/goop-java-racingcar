package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.view.ResultView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingTrackTest {

    @Test
    void startRace() {
        RacingTrack racingTrack = RacingTrack.of(4);
        ResultView resultView = racingTrack.startRace();
        String result = resultView.display();
        int length = result.split("\n").length;

        assertThat(length).isEqualTo(4);
    }

    @Test
    void of() {
    }
}