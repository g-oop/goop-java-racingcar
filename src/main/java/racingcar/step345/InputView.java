package racingcar.step345;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return this.scanner.nextInt();
    }

    public int inputNumberOfLaps() {

        System.out.println("시도할 회수는 몇 회 인가요?");
        return this.scanner.nextInt();
    }
}
