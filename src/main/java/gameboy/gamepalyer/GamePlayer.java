package gameboy.gamepalyer;

import gameboy.gamepack.*;
import gameboy.gamepack.racinggame.RacingGamePack;

public class GamePlayer {

    public GamePlayer() { }

    public void startGame(GamePack gamePack) {
        gamePack.play();
    }

    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.startGame(new RacingGamePack());
    }

}
