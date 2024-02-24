package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.domain.entity.RacingGameResult;
import racingcar.domain.strategy.RandomNumberGenerator;
import racingcar.view.RacingGameResultView;

import static racingcar.view.RacingGameInputView.getAttemptCount;
import static racingcar.view.RacingGameInputView.getCarNames;

public class GameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        RacingGameResult result = game.race(getCarNames(), getAttemptCount(), new RandomNumberGenerator());
        RacingGameResultView.printResult(result);
    }
}
