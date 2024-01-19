package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void drive() {
        //given
        Driver driver = new Driver();
        //when
        int result = driver.drive();
        //then
        assertThat(result).isBetween(0, 1);

    }
}