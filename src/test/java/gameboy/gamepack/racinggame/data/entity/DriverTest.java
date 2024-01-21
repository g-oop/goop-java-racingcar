package gameboy.gamepack.racinggame.data.entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    @ParameterizedTest
    @DisplayName("drive 주행 테스트")
    @ValueSource(ints = {4, 10})
    void drive_주행(int randomInt) {
        //given
        Driver driver = new Driver(new TestRandom(randomInt));
        //when
        driver.drive();
        //then
        assertThat(driver.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("drive 정지 테스트")
    @ValueSource(ints = {0, 3})
    void drive_정지(int randomInt) {
        //given
        Driver driver = new Driver(new TestRandom(randomInt));
        //when
        driver.drive();
        //then
        assertThat(driver.getPosition()).isEqualTo(0);
    }


}
