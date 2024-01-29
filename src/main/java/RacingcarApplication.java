import service.RacingGame;
import strategy.NumberGenerator;
import strategy.NumberGeneratorImpl;
import ui.InputResult;
import ui.OutputResult;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputResult inputResult = new InputResult();
        OutputResult outputResult = new OutputResult();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        int carCount = inputResult.getCarCount();
        RacingGame racingGame = new RacingGame(carCount, numberGenerator);
        racingGame.play(inputResult, outputResult);
    }
}
