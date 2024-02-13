package racingcar.step345;

public class Race {

    public static void main(String[] args) {

        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfLaps =  InputView.inputNumberOfLaps();

        Game game = new Game(numberOfCars, numberOfLaps);

        Rule rule = new RandomRule();
        game.begin(rule);
    }
}
