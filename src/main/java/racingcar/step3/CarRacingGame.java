package racingcar.step3;


public class CarRacingGame {
    public static void main(String[] args) {

        InputDto inputDto = InputView.getNumberOfCarsAndAttempts();

        Race race = new Race(inputDto.getNumberOfCars());
        race.start(inputDto.getNumberOfAttempts());
    }
}


