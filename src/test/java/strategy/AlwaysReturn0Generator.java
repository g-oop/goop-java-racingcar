package strategy;

public class AlwaysReturn0Generator implements NumberGenerator {

    @Override
    public int generateRandomValue() {
        return 0;
    }
}
