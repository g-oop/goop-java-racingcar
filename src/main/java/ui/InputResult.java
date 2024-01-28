package ui;

import java.util.Scanner;

public class InputResult {

    private static final Scanner scanner = new Scanner(System.in);

    public int getCarCount() {
        return getInput("자동차 대수는 몇 대 인가요?");
    }

    public int getTryCount() {

        return getInput("시도할 회수는 몇 회 인가요?");
    }

    private int getInput(String message) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(message);
                input = Integer.parseInt(scanner.nextLine());

                if (input <= 0) {
                    System.out.println("0보다 큰 정수를 입력하세요");
                    continue;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
            }
        }
        return input;
    }


}
