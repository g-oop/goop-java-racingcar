package gameboy.gamepack.racinggame.data.vo;

public class Position {

    public static final int MIN_POSITION_VALUE = 0;

    private int position;

    public Position() { }

    public Position(int position) {
        validationPosition(position);
        this.position = position;
    }

    private void validationPosition(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(MIN_POSITION_VALUE + "미만의 포지션 생성: " + position);
        }
    }

    public void addOne() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return this.getClass().getTypeName().hashCode() + position;
    }
}
