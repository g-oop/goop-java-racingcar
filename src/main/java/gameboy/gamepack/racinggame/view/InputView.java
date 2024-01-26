package gameboy.gamepack.racinggame.view;

import java.util.*;
import java.util.stream.Collectors;

import gameboy.gamepack.racinggame.data.vo.Name;
import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;

public class InputView {

    private static final String CARS_NAME_SEPARATOR = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputRaceCount() {
        return inputNumber("시도할 회수는 몇 회 인가요?");
    }

    public static List<Name> inputCarsName() {
        return inputCarsName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private static List<Name> inputCarsName(String ask) {
        try {
            List<String> carNames = split(inputText(ask), CARS_NAME_SEPARATOR);
            validDuplicateName(carNames);
            return carNames.stream()
                .map(Name::new)
                .toList();
        } catch (InvalidRacerNameException e) {
            return inputCarsName(e.getMessage());
        }
    }

    private static List<String> split(String text, String separator) {
        List<String> carNames = List.of(text.split(separator))
            .stream()
            .map(String::trim)
            .collect(Collectors.toList());
        return carNames;
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
        return SCANNER.nextInt();
    }

    private static String userTextInput() {
        return SCANNER.nextLine();
    }

    private static void validDuplicateName(List<String> carNames) {
        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new InvalidRacerNameException("자동차 이름이 중복될 수 없습니다.");
        }
    }

}
