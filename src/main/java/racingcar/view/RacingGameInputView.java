package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingGameInputView {

    private static final String DEFAULT_DELIMITER = ",";
    private static final int CAR_NAME_LIMIT = 5;

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID_INPUT_MESSAGE = "숫자를 입력해주세요.";

    public static int getCarCount() {
        return getNumberInput("자동차 대수는 몇 대 인가요?");
    }

    public static int getAttemptCount() {
        return getNumberInput("시도할 회수는 몇 회 인가요?");
    }


    public static String[] getCarNames() {
        String[] carNames = tokenize(getCarNamesInput());
        for (String carName: carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private static String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static String[] tokenize(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

    private static void validateCarName(String carName) {
        if (carName.trim().length() > CAR_NAME_LIMIT) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
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
