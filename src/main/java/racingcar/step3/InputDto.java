package racingcar.step3;

public class InputDto {

    int numberOfCars;
    int numberOfAttempts;

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public InputDto(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
    }
}
