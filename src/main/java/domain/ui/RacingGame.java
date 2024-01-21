package domain.ui;

import java.util.*;

import domain.Car;
import domain.util.RacingCarInputHandler;
import domain.util.OutputHandler;

public class RacingGame implements Game{
    private List<Car> cars;
    private RacingCarInputHandler racingCarInputHandler;
    private OutputHandler outputHandler;

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.racingCarInputHandler = new RacingCarInputHandler();
    }

    private int carCount = 0;
    private int moveCount = 0;

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void play() {

        getCountFromUser();

        for (int move = 0; move < moveCount; move++) {
            OutputHandler.printMessage("\n" + (move + 1) + "회차:");
            moveCars();
            printCarStates();
        }
        printFinalResult();
    }

    private void getCountFromUser() {
        carCount = racingCarInputHandler.getInput("자동차 대수는 몇 대 인가요? ");
        moveCount = racingCarInputHandler.getInput("이동 횟수는 몇 회 인가요? ");
        initializeCars(carCount);
    }



    private void initializeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            String carName = racingCarInputHandler.getCarNameFromUser("자동차 이름을 입력하세요: ");
            cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void printCarStates() {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getState());
        }
    }

    public void printFinalResult() {
        OutputHandler.printMessage("\n최종 결과:");
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getState());
        }
    }
}
