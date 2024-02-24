package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomNumberGenerator;

import static racingcar.view.RacingGameInputView.getAttemptCount;
import static racingcar.view.RacingGameInputView.getCarNames;

public class GameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(getCarNames(), new RandomNumberGenerator());
        game.race(getAttemptCount());
    }
}
