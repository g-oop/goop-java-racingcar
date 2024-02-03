import java.util.List;

import service.RacingGame;
import strategy.NumberGenerator;
import strategy.NumberGeneratorImpl;

import static ui.InputResult.getCarNameFromUser;
import static ui.InputResult.getTryCount;
import static ui.OutputResult.printMessage;
import static ui.OutputResult.printWinner;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        String[] carNames = getCarNameFromUser();
        int tryCount = getTryCount();
        RacingGame racingGame = new RacingGame(numberGenerator, carNames);
        printMessage("\n실행 결과:");
        List<String> winners = racingGame.play(tryCount);
        printWinner(winners);
    }
}
