package step1.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION2 = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCarCount() {
        return inputToNum(QUESTION);
    }

    public static int getTryCount() {
        return inputToNum(QUESTION2);
    }

    private static int inputToNum(String question) {
        while (true) {
                System.out.println(question);
                String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요.");
            }
        }
    }

}
