package racingcar.domain.car;

import racingcar.domain.RandomNumberGenerator;

public class DefaultCar implements Car{
    private static final int MOVE_THRESHOLD = 4;
    private static final String DEFAULT_NAME = "CAR ";

    private final RandomNumberGenerator numberGenerator;
    private final String name;
    private int position;

    public DefaultCar(RandomNumberGenerator numberGenerator, String name) {
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }

    public DefaultCar(RandomNumberGenerator numberGenerator) {
        this(numberGenerator, DEFAULT_NAME);
    }


    @Override
    public void move() {
        if (numberGenerator.generate() >= MOVE_THRESHOLD){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
