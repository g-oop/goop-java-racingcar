package gameboy.gamepalyer.console;

import java.util.Scanner;

public class InputConsole {

    public static int inputNumber(String ask) {
        display(ask);
        return userAnswer();
    }

    private static void display(String ask) {
        System.out.println(ask);
    }

    private static int userAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
