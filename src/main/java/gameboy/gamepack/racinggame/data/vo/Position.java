package gameboy.gamepack.racinggame.data.vo;

public class Position implements Comparable<Position> {

    private static final int MIN_POSITION_VALUE = 0;

    private int value;

    public Position() { }

    public Position(int value) {
        validationPosition(value);
        this.value = value;
    }

    private void validationPosition(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(MIN_POSITION_VALUE + "미만의 포지션 생성: " + position);
        }
    }

    public void addOne() {
        value += 1;
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.hashCode() == obj.hashCode()
            && this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Position o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.value > o.value) {
            return 1;
        }
        return -1;
    }

}
