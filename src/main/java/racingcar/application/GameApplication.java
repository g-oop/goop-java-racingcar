package racingcar.application;

import racingcar.domain.game.RacingGame;
import racingcar.view.RacingGameInputView;

public class GameApplication {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(RacingGameInputView.getCarNames());
        game.start();
    }
}
