package racingcar.application;

import racingcar.domain.game.*;
import racingcar.view.InputView;
import racingcar.view.RacingGameView;

public class GameApplication {

    public static void main(String[] args) {
        GameInitializer gameInitializer = new RacingGameInitializer(new RacingGameView(new InputView()));
        Game game = gameInitializer.init();
        game.start();
    }
}
