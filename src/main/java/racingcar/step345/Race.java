package racingcar.step345;

public class Race {

    public static void main(String[] args) {

        Rule rule = new RandomRule();

        Game game = new Game();
        game.begin(rule);
    }
}
