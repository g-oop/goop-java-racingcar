package racingcar.domain.car;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random = new Random();
    private static final int DEFAULT_BOUND = 10;
    private int bound;


    public RandomNumberGenerator() {
        this.bound = DEFAULT_BOUND;
    }

    public RandomNumberGenerator(int bound) {
        this.bound = bound;
    }

    public int generate(){
        return random.nextInt(bound);
    }



    public void setRandom(Random random) {
        this.random = random;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }
}
