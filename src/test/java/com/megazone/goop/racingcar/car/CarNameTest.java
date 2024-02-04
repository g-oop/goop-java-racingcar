package com.megazone.goop.racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.megazone.goop.racingcar.car.CarName;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"santafe", "sonata"})
    void carNameMaxLengthTest(String name) {
        assertThatThrownBy(() ->
            new CarName(name)
        ).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 이름은 공백이 아닌 1자 이상 입력해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void emptyCarNameTest(String name) {
        assertThatThrownBy(() ->
            new CarName(name)
        ).isInstanceOf(RuntimeException.class);
    }
}
