package racingcar.domain.car;

import racingcar.domain.numbergenerator.RandomNumberGenerator;

public class DefaultCar implements Car{
    private static final int MOVE_THRESHOLD = 4;

    private final RandomNumberGenerator numberGenerator;
    private final String name;
    private int position;

    public DefaultCar(RandomNumberGenerator numberGenerator, String name) {
        this.numberGenerator = numberGenerator;
        this.name = name;
        this.position = 0;
    }


    @Override
    public void move() {
        if (isMovable()){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isMovable(){
        return numberGenerator.generate() >= MOVE_THRESHOLD;
    }

}
