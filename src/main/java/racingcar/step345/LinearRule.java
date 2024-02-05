package racingcar.step345;

public class LinearRule implements Rule {

    @Override
    public boolean isStop() {
        return false;
    }

    @Override
    public int getStopCount() {
        return 0;
    }
}
