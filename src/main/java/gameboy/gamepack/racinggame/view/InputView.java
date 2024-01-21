package gameboy.gamepack.racinggame.view;

import java.util.Scanner;

public class InputView {

    public static int inputNumber(String ask) {
        display(ask);
        return userIntInput();
    }

    private static void display(String ask) {
        System.out.println(ask);
    }

    private static int userIntInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
