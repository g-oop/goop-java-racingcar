package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    private Random random = new Random();
    private int bound;

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
