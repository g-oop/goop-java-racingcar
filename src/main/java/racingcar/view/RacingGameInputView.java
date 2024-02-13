package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGameInputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "숫자를 입력해주세요.";

    public static int getCarCount() {
        return getNumberInput("자동차 대수는 몇 대 인가요?");
    }

    public static int getAttemptCount() {
        return getNumberInput("시도할 회수는 몇 회 인가요?");
    }

    private static int getNumberInput(String message) {
        try {
            System.out.println(message);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException(INVALID_INPUT_MESSAGE);
        }
    }

}
