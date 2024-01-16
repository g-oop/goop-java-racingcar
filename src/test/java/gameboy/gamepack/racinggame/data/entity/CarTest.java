package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @DisplayName(value = "")
    @Test
    void wheelMarks() {
        Car car = new Car();
        String result = car.wheelMark();
        assertThat(result).isEqualTo("");
    }

}