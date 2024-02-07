package view;

import java.util.List;

import domain.Car;

public class OutputResult {


    public static void printWinner(List<String> winners) {

        System.out.println("우승자는 " + String.join(", ", winners) + " 입니다!");
    }


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printCarsNameLocation(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(getState(car.getName(), car.getPosition()));
        }
        System.out.println("\n");
    }


    private static String getState(String carName, int position) {
        return carName + ": " +
            "-".repeat(Math.max(0, position)) +
            ">";
    }


}
