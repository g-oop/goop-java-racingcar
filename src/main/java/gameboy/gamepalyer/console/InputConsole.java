package gameboy.gamepalyer.console;

import java.util.Scanner;

import gameboy.gamepack.racinggame.view.TextView;

public class InputConsole {

    public static int askUserInput(TextView ask) {
        display(ask);
        return userAnswer();
    }

    private static void display(TextView ask) {
        System.out.println(ask.display());
    }

    private static int userAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
