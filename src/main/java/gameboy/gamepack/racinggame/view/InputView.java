package gameboy.gamepack.racinggame.view;

public class InputView implements TextView {

    private String inputGuide;

    public InputView(String inputGuide) {
        this.inputGuide = inputGuide;
    }

    @Override
    public String display() {
        return inputGuide;
    }
}
