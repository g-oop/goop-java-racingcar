package racingcar.mock;

import racingcar.entry.MovePolicy;

public class AlwaysMovePolicy implements MovePolicy {

    @Override
    public boolean canMove() {
        return true;
    }
}
