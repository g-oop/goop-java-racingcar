package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    @Test
    @DisplayName("drive 정상 테스트")
    void drive() {
        //given
        Driver driver = new Driver();
        //when
        int result = driver.drive();
        //then
        assertThat(result).isBetween(0, 1);

    }
}