package gameboy.gamepack.racinggame.view;

import java.util.List;

public class ResultView implements TextView {

    private String resultText;

    public ResultView(List<Integer> carsPosition) {
        this.resultText = getRaceResult(carsPosition);
    }

    private String getRaceResult(List<Integer> carsPosition) {
        return carsPosition.stream().map(this::wheelMark).toString();
    }

    public String wheelMark(int carPosition) {
        String wheelMark = "";
        for(int i = 0; i < carPosition; i ++) {
            wheelMark += "-";
        }
        return wheelMark + "\n";
    }

    @Override
    public String display() {
        return resultText;
    }
}
