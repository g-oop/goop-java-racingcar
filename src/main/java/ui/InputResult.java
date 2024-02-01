package ui;

import java.util.Scanner;

public class InputResult {

    private static final Scanner scanner = new Scanner(System.in);


    public int getTryCount() {
        return getIntegerInputFromUser("시도할 회수는 몇 회 인가요?");
    }
    
    private int getIntegerInputFromUser(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다. 정수를 입력하세요.");
        }
        return getIntegerInputFromUser(message);
    }

    public String[] getCarNameFromUser() {
        String[] carNames;
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNames = scanner.nextLine().trim().split(",");
        return carNames;
    }

}
