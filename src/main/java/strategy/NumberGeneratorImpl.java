package strategy;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    public static final Random RANDOM = new Random();
    private static final int RANGE_NUMBER = 10;


    @Override
    public int generateRandomValue() {
        return RANDOM.nextInt(RANGE_NUMBER);
    }
}