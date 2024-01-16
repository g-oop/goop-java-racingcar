package gameboy.gamepack.racinggame.view;

public class ResultView implements TextView {

    private String resultText;

    public ResultView(String resultText) {
        this.resultText = resultText;
    }

    @Override
    public String display() {
        return resultText;
    }
}
