package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "숫자를 입력해주세요.";

    public static int getNumberInput(String message) {
        try {
            System.out.println(message);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException(INVALID_INPUT_MESSAGE);
        }
    }

}
