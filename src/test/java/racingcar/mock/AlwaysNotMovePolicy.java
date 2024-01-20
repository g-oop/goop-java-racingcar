package racingcar.mock;

import racingcar.entry.MovePolicy;

public class AlwaysNotMovePolicy implements MovePolicy {

    @Override
    public boolean canMove() {
        return false;
    }
}
