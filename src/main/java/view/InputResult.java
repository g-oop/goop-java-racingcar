package view;

import java.util.Scanner;

public class InputResult {

    private static final Scanner SCANNER = new Scanner(System.in);


    public static int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = SCANNER.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
        }
        return getTryCount();
    }

    public static String[] getCarNameFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return SCANNER.nextLine().trim().split(",");
    }

}
