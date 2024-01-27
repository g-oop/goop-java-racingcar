package step1.racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getCarCount() {
        return inputToNum("자동차 대수는 몇 대 인가요?");
    }

    public static int getTryCount() {
        return inputToNum("시도할 횟수는 몇 회 인가요?");
    }

    private static int inputToNum(String question) {
        System.out.println(question);
        String input = SCANNER.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값이 입력되었습니다.");
            return inputToNum(question);
        }
    }

}
