package racingcar.step345;

public class Race {

    public static void main(String[] args) {
        printResult(setUpGame());
    }

    private static Game setUpGame() {
        return new Game(InputView.inputNumberOfCars(), InputView.inputNumberOfLaps());
    }

    private static void printResult(Game game) {
        ResultView.printResult(game.begin(new RandomRule()));
    }
}
