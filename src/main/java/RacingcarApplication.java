import service.RacingGame;
import ui.InputResult;
import ui.OutputResult;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputResult inputResult = new InputResult();
        OutputResult outputResult = new OutputResult();
        int carCount = inputResult.getCarCount();
        RacingGame racingGame = new RacingGame(carCount);
        racingGame.play(inputResult, outputResult);
    }
}
