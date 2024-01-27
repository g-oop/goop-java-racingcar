package ui;

public class OutputResult {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCarStates(int[] positions) {
        for (int position: positions) {
            System.out.println(getState(position));
        }
        System.out.println("\n");
    }

    private String getState(int position) {
        StringBuilder state = new StringBuilder("|");
        state.append("-".repeat(Math.max(0, position)));
        state.append(">");
        return state.toString();
    }
}
