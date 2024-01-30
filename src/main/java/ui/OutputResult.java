package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputResult {


    public static void printWinner(List<String> winners) {
        System.out.println("우승자는 " + String.join(", ", winners.get(winners.size() - 1)) + " 입니다!");
    }

    public static List<String> determineWinner(String[] carNames, int[] positions) {
        printCars(carNames, positions);
        int maxPosition = Arrays.stream(positions).max().orElse(0);
        return getWinners(carNames, positions, maxPosition);
    }

    private static List<String> getWinners(String[] carNames, int[] positions, int maxPosition) {
        return IntStream.range(0, positions.length)
            .filter(i -> positions[i] == maxPosition)
            .mapToObj(i -> carNames[i])
            .collect(Collectors.toList());
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printCars(String[] carNames, int[] positions) {
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
