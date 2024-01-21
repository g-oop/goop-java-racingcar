package gameboy.gamepack.racinggame.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static int inputNumber(String ask) {
        try {
            display(ask);
            return userIntInput();
        }catch (InputMismatchException e) {
            return inputNumber("숫자만 입력해주세요.");
        }
    }

    private static void display(String ask) {
        System.out.println(ask);
    }

    private static int userIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
