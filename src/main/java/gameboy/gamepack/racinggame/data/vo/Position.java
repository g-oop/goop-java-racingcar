package gameboy.gamepack.racinggame.data.vo;

import java.util.Objects;

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
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        return Objects.equals(value, ((Position) that).value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position that) {
        if (this.equals(that)) {
            return 0;
        }
        if (this.value > that.value) {
            return 1;
        }
        return -1;
    }

}
