package racingcar.application;

import racingcar.domain.game.Game;
import racingcar.domain.game.RacingGame;

public class GameApplication {

    public static void main(String[] args) {
        Game game = new RacingGame();
        game.start();
    }
}
