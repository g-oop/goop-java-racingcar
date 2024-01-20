package gameboy.gamepack.racinggame.view;

public class InputView {

    private String inputGuide;

    public InputView(String inputGuide) {
        this.inputGuide = inputGuide;
    }

    public String display() {
        return inputGuide;
    }
}
