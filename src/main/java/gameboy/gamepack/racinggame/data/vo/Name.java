package gameboy.gamepack.racinggame.data.vo;

import gameboy.gamepack.racinggame.exception.InvalidRacerNameException;

public class Name {

    private static final int MAX_NAME_SIZE = 5;

    String name;

    public Name(String name) {
        validationName(name);
        this.name = name;
    }

    private void validationName(String name) {
        if (name.isBlank()) {
            throw new InvalidRacerNameException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidRacerNameException("자동차 이름이 " + MAX_NAME_SIZE + "글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

}
