package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.domain.strategy.RandomNumberGenerator;

import static racingcar.view.RacingGameInputView.getAttemptCount;
import static racingcar.view.RacingGameInputView.getCarNames;
import static racingcar.view.RacingGameResultView.printResult;
import static racingcar.view.RacingGameResultView.printWinners;

public class GameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(getCarNames(), new RandomNumberGenerator());
        RacingGameResult result = game.race(getAttemptCount());
        printResult(result);
        printWinners(game.getWinners());
    }
}
