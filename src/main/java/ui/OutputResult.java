package ui;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;

public class OutputResult {


    public static void printWinner(List<String> winners) {

        System.out.println("우승자는 " + String.join(", ", winners) + " 입니다!");
    }

    public static List<String> determineWinner(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printCars(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(getState(carNames[i], positions[i]));
        }
        System.out.println("\n");
    }


    private static String getState(String carName, int position) {
        StringBuilder state = new StringBuilder();
        state.append(carName).append(": ");
        state.append("-".repeat(Math.max(0, position)));
        state.append(">");
        return state.toString();
    }


}
