import service.RacingGame;
import strategy.RandomMoveStrategy;
import strategy.RandomMoveStrategyImpl;
import ui.InputResult;
import ui.OutputResult;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputResult inputResult = new InputResult();
        OutputResult outputResult = new OutputResult();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategyImpl();
        int carCount = inputResult.getCarCount();
        RacingGame racingGame = new RacingGame(carCount, randomMoveStrategy);
        racingGame.play(inputResult, outputResult);
    }
}
