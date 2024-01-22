package gameboy.gamepack.racinggame.data.vo;

public class CarStatus {
    private String name;
    private int position;

    public CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
