package strategy;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    public static final Random RANDOM = new Random();


    @Override
    public int generateRandomValue(int rangeNumber) {
        return RANDOM.nextInt(rangeNumber);
    }
}
