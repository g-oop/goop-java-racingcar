package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    private final int DRIVE_SEED = 1;
    private final int STOP_SEED = 4;

    @ParameterizedTest
    @DisplayName("drive 정상 테스트")
    @CsvSource({
        DRIVE_SEED + "," + 1,
        STOP_SEED + "," + 0
    })
    void drive(int seed, int expected) {
        //given
        Driver driver = new Driver(new Random(seed));
        //when
        driver.drive();
        //then
        assertThat(driver.getPosition()).isEqualTo(expected);
    }
}
