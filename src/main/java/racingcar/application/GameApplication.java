package racingcar.application;

import racingcar.domain.RacingGame;

import static racingcar.view.RacingGameInputView.getAttemptCount;
import static racingcar.view.RacingGameInputView.getCarNames;

public class GameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(getCarNames());
        game.race(getAttemptCount());
    }
}
