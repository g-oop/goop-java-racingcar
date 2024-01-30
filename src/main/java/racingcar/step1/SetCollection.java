package racingcar.step1;

import java.util.Set;

public class SetCollection {

    private Set<Integer> numbers;

    public SetCollection(Set<Integer> inputNumbers) {
        this.numbers = inputNumbers;
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(Integer inputInteger) {
        return numbers.contains(inputInteger);
    }
}
