import domain.RacingGame;
import ui.*;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputProvider inputProvider = new InputResult();
        OutputProvider outputProvider = new OutputResult();
        RacingGame racingGame = new RacingGame(inputProvider, outputProvider);
        racingGame.play();
    }
}
