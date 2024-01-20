package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "숫자를 입력해주세요.";


    private int getNumberInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
                scanner.nextLine();
            }
        }
    }

}
