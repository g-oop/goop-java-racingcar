package strategy;

public class AlwaysReturn5Generator implements NumberGenerator {
    
    @Override
    public int generateRandomValue() {
        return 5;
    }
}
