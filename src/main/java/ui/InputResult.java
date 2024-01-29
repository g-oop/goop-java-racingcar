package ui;

import java.util.Scanner;

public class InputResult {

    private static final Scanner scanner = new Scanner(System.in);

    public int getCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public int getInput(String message) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());

                if (input <= 0) {
                    System.out.println("0보다 큰 정수를 입력하세요.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
            }
        }
        return input;
    }


}
