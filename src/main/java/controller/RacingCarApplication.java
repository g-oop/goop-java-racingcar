package controller;

import java.util.List;

import domain.Cars;
import service.RacingGame;
import strategy.NumberGenerator;
import strategy.NumberGeneratorImpl;

import static view.InputResult.getCarNameFromUser;
import static view.InputResult.getTryCount;
import static view.OutputResult.printMessage;
import static view.OutputResult.printWinner;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGeneratorImpl();
        String[] carNames = getCarNameFromUser();
        int tryCount = getTryCount();
        Cars cars = new Cars();
        RacingGame racingGame = new RacingGame(numberGenerator, cars, carNames);
        printMessage("\n실행 결과:");
        List<String> winners = racingGame.play(tryCount);
        printWinner(winners);
    }
}
