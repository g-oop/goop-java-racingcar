package step1.racingcar.view;

import java.util.Scanner;

import step1.racingcar.utils.StringSplitUtils;

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

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return splitNames(SCANNER.nextLine());
    }

    private static String[] splitNames(String carNames) {
        return StringSplitUtils.splitBySeparator("//,\n" + carNames);
    }


}
