package gameboy.gamepack.racinggame.domain.data.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int MIN_POSITION_VALUE = 0;
    public static final Position MIN = new Position(MIN_POSITION_VALUE);

    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        validationPosition(value);
        this.value = value;
    }

    private void validationPosition(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(MIN_POSITION_VALUE + "미만의 포지션 생성: " + position);
        }
    }

    public Position addOne() {
        return new Position(value + 1);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Position position)) {
            return false;
        }
        return this.value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position that) {
        return this.value - that.value;
    }

}
