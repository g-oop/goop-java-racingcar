package gameboy.gamepack.racinggame.view;

import java.util.List;

public class ResultView implements TextView {

    private String resultText;

    public ResultView(List<Integer> carsPosition) {
        this.resultText = getRaceResult(carsPosition);
    }

    private String getRaceResult(List<Integer> carsPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        carsPosition.stream().forEach(position -> stringBuilder.append(createWheelMark(position)));
        return stringBuilder.toString();
    }

    private String createWheelMark(int carPosition) {
        String wheelMark = "";
        for (int i = 0; i < carPosition; i++) {
            wheelMark += "-";
        }
        return wheelMark + "\n";
    }

    @Override
    public String display() {
        return resultText;
    }
}
