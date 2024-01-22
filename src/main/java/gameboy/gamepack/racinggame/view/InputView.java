package gameboy.gamepack.racinggame.view;

import java.util.*;

import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;

public class InputView {

    private static final int MAX_NAME_SIZE = 5;

    public static int inputNumber(String ask) {
        try {
            display(ask);
            return userIntInput();
        } catch (InputMismatchException e) {
            return inputNumber("숫자만 입력해주세요.");
        }
    }

    public static List<String> inputRacerName(String ask) {
        try {
            display(ask);
            return List.of(userStringInput().split(",")).stream()
                .filter(InputView::validationRacerName)
                .map(String::trim).toList();
        } catch (InvalidRacerNameException e) {
            return inputRacerName(e.getMessage());
        }
    }

    private static void display(String ask) {
        System.out.println(ask);
    }

    private static int userIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String userStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean validationRacerName(String name) {
        if (name.isBlank()) {
            throw new InvalidRacerNameException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidRacerNameException("자동차 이름이 " + MAX_NAME_SIZE + "글자를 초과할 수 없습니다.");
        }
        return true;
    }

}
