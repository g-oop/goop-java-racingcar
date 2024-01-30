package ui;

public class OutputResult {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printCarStates(String[] carNames, int[] positions) {
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
