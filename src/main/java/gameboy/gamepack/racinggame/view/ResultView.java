package gameboy.gamepack.racinggame.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void display(List<Integer> carsPosition) {
        System.out.println(getRaceResult(carsPosition));
    }

    public static String getRaceResult(List<Integer> carsPosition) {
        return carsPosition.stream().map(ResultView::createWheelMark).collect(Collectors.joining("\n","", "\n"));
    }

    private static String createWheelMark(int carPosition) {
        return "-".repeat(carPosition);
    }
}
