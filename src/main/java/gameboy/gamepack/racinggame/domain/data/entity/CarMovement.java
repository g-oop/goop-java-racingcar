package gameboy.gamepack.racinggame.domain.data.entity;

import java.util.Random;

import gameboy.gamepack.racinggame.domain.data.vo.Position;

public class CarMovement implements Movement {

    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;
    private final Random random;

    public CarMovement() {
        this(new Random());
    }

    public CarMovement(Random random) {
        this.random = random;
    }

    @Override
    public Position move(Position position) {
        if (isPushAccelerator()) {
            return position.addOne();
        }
        return new Position(position.value());
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }
}
