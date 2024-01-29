package domain.util;

import java.util.*;

public class RacingCarInputHandler implements InputHandler{

    private static final Scanner scanner = new Scanner(System.in);


    public int getInput(String message) {
        int input = 0;
        while (true) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
            return input;
        }

    }

    public String getCarNameFromUser(String message) {
        String carName = null;
        try {
            System.out.print(message);
            carName = scanner.nextLine();
            if (carName.trim().isEmpty()) {
                carName = "DefaultCar";
            }
        } catch (NoSuchElementException e) {
            carName = "DefaultCar";
        }

        return carName;
    }


}
