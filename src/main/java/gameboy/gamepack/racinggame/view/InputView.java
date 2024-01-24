package gameboy.gamepack.racinggame.view;

import java.util.*;

import gameboy.gamepack.racinggame.data.vo.Name;
import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;

public class InputView {

    private static final int MAX_NAME_SIZE = 5;
    private static final String CARS_NAME_SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputRaceCount() {
        return inputNumber("시도할 회수는 몇 회 인가요?");
    }

    public static List<Name> inputCarsName() {
        return inputCarsName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").stream().map(Name::new).toList();
    }

    private static List<String> inputCarsName(String ask) {
        try {
            List<String> carsName = split(inputText(ask), CARS_NAME_SEPARATOR);
            carsName.forEach(InputView::validRacerName);
            return carsName;
        } catch (InvalidRacerNameException e) {
            return inputCarsName(e.getMessage());
        }
    }

    private static int inputNumber(String ask) {
        try {
            display(ask);
            return userIntInput();
        } catch (InputMismatchException e) {
            return inputNumber("숫자만 입력해주세요.");
        }
    }

    public static String inputText(String ask) {
        display(ask);
        return userTextInput();
    }

    private static void display(String message) {
        System.out.println(message);
    }

    private static int userIntInput() {
        return scanner.nextInt();
    }

    private static String userTextInput() {
        return scanner.nextLine();
    }

    private static List<String> split(String text, String separator) {
        List<String> tokens = List.of(text.split(separator));
        return tokens.stream().map(String::trim).toList();
    }

    private static void validRacerName(String name) {
        if (name.isBlank()) {
            throw new InvalidRacerNameException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidRacerNameException("자동차 이름이 " + MAX_NAME_SIZE + "글자를 초과할 수 없습니다.");
        }
    }

}
