package gameboy.gamepack.racinggame.data.dto;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 - RaceResultDto 테스트")
class RaceResultDtoTest {

    @Test
    @DisplayName("레이싱 결과 텍스트 생성 테스트")
    void getRaceResult() {
        //given
        List<Integer> carsPosition = List.of(1, 2, 3, 4);
        RaceResultDto raceResultDto = RaceResultDto.of(carsPosition);
        String expected = """
            -
            --
            ---
            ----
            """;
        //when
        String result = raceResultDto.getRaceResult();
        //then
        assertThat(result).isEqualTo(expected);
    }
}
