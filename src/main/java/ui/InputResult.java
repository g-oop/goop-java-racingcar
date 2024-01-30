package ui;

import java.util.Scanner;

public class InputResult {

    private static final Scanner scanner = new Scanner(System.in);


    public int getTryCount() {
        return getInput("시도할 회수는 몇 회 인가요?");
    }

    public String getCarNameFromUser() {
        return getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    private int getInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
        }
        return getInput(message);
    }

    private String getInputString(String message) {
        String carName;
        System.out.println(message);
        carName = scanner.nextLine();
        try {
            if (carName.trim().isEmpty()) {
                carName = "DefaultCar";
            }
        } catch (IllegalArgumentException e) {
            System.out.println("유효하지 않는 이름입니다.");
        }
        return carName;
    }

}
