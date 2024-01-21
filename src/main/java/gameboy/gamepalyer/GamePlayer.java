package gameboy.gamepalyer;

import gameboy.gamepack.GamePack;
import gameboy.gamepack.racinggame.RacingGamePack;

public class GamePlayer {

    public static void main(String[] args) {
        GamePack racingGame = new RacingGamePack();
        racingGame.play();
    }

}
