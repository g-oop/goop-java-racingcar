package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entry.Car;
import racingcar.mock.Always4OrMoreRandom;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("지정한 수만큼 경주 참가자가 생성된다.")
    void create() {
        int entryCount = 3;
        int moveCount = 5;
        Random random = new Random();
        RacingUi racingUi = new TestGameUi(entryCount, moveCount);
        RacingPreference preference = racingUi.inputPreference();

        RacingGame racingGame = new RacingGame(preference, racingUi, random);

        int result = racingGame.getRacingEntryCount();
        assertThat(result).isEqualTo(entryCount);
    }

    @Test
    @DisplayName("게임을 시작하면, 각 경주 참가자가 이동 횟수만큼 이동한다.")
    void start() {
        int entryCount = 3;
        int moveCount = 5;
        Random random = new Always4OrMoreRandom();
        RacingUi racingUi = new TestGameUi(entryCount, moveCount);
        RacingPreference preference = racingUi.inputPreference();

        RacingGame racingGame = new RacingGame(preference, racingUi, random);
        racingGame.start();

        RacingEntries racingEntries = racingGame.getRacingEntries();
        for (Car car: racingEntries.getEntries()) {
            assertThat(car.currentPosition()).isEqualTo(moveCount);
        }
    }


    static class TestGameUi implements RacingUi {

        private final int carCount;
        private final int moveCount;

        public TestGameUi(int carCount, int moveCount) {
            this.carCount = carCount;
            this.moveCount = moveCount;
        }

        @Override
        public RacingPreference inputPreference() {
            return new RacingPreference(carCount, moveCount);
        }

        @Override
        public void showStatus(RacingGame racingGame) {
            //noop
            //new RacingConsoleUi().showStatus(racingGame);
        }
    }

}
