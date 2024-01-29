import domain.RacingGame;
import ui.InputResult;
import ui.OutputResult;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputResult inputResult = new InputResult();
        OutputResult outputResult = new OutputResult();
        RacingGame racingGame = new RacingGame(inputResult, outputResult);
        racingGame.play(inputResult, outputResult);
    }
}
