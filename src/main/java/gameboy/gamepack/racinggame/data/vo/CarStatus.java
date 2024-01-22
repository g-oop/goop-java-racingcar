package gameboy.gamepack.racinggame.data.vo;

public class CarStatus {
    private Name name;
    private Position position;

    public CarStatus(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void positionAdd() {
        position.add();
    }
    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
