package step1.vo;

import java.util.Random;

import step1.view.ResultView;

public class Car {

    private int loc;
    private static final int BOUND = 10;
    private static final int MINIMUM_CONDITION = 4;

    public Car() {
        loc = 1;
    }

    public void moveForward() {
        int forwardCount = getRandom(BOUND);
        if (isValid(forwardCount)) {
            loc += forwardCount;
        }
        ResultView.drawMoveStatus(loc);
    }

    private boolean isValid(int forwardCount) {
        return forwardCount >= MINIMUM_CONDITION;
    }

    public int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public int getLoc() {
        return loc;
    }
}
