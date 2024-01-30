package gameboy.gamepack.racinggame.domain.data.vo;

import java.util.Objects;

import gameboy.gamepack.racinggame.domain.data.exception.InvalidRacerNameException;

public class Name {

    private static final int MAX_NAME_SIZE = 5;

    private String name;

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

    @Override
    public boolean equals(Object that) {
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        return Objects.equals(name, ((Name) that).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
