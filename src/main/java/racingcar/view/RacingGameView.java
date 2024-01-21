package racingcar.view;

import java.util.List;

import racingcar.domain.game.RacingGame;
import racingcar.domain.car.Car;

public class RacingGameView {

    private final InputView inputView;

    public RacingGameView(InputView inputView) {
        this.inputView = inputView;
    }

    public int getCarCount() {
        return inputView.getNumberInput("자동차 대수는 몇 대 인가요?");
    }

    public int getAttemptCount() {
        return inputView.getNumberInput("시도할 회수는 몇 회 인가요?");
    }


    public void printCurrentStatus(RacingGame racingGame) {
        List<Car> cars = racingGame.getCars();
        drawCarPaths(cars);
    }

    private void drawCarPaths(List<Car> cars) {
        for (Car car: cars) {
            drawCarPath(car);
        }
        System.out.println();

    }

    private void drawCarPath(Car car) {
        System.out.print(car.getName() + "|");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.print("⛟");
        System.out.println();
    }
}
