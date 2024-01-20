package gameboy.gamepalyer;

import gameboy.gamepack.*;
import gameboy.gamepack.racinggame.RacingGamePack;

public class GamePlayer {

    public static void main(String[] args) {
        RacingGamePack racingGame = new RacingGamePack();
        racingGame.play();
    }

}
