import java.util.List;

import service.RacingGame;
import strategy.NumberGenerator;
import strategy.NumberGeneratorImpl;
import ui.InputResult;

import static ui.OutputResult.printMessage;
import static ui.OutputResult.printWinner;

public class RacingcarApplication {

    public static void main(String[] args) {
        InputResult inputResult = new InputResult();
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        String[] carNames = inputResult.getCarNameFromUser();
        int tryCount = inputResult.getTryCount();
        RacingGame racingGame = new RacingGame(numberGenerator, carNames);
        printMessage("\n실행 결과:");
        List<String> winners = racingGame.play(tryCount);
        printWinner(winners);
    }
}
