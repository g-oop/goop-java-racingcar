package gameboy.gamepack.racinggame.view;

import java.util.List;

import gameboy.gamepack.racinggame.data.entity.Car;
import gameboy.gamepack.racinggame.data.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("VIEW - ResultView 테스트")
class ResultViewTest {

    @Test
    @DisplayName("결과 출력 테스트")
    void display_정상결과() {
        //given
        List<Car> carsPosition = List.of(
            new Car(new Position(1)),
            new Car(new Position(2)),
            new Car(new Position(3)),
            new Car(new Position(4))
        );
        String expected = """
            -
            --
            ---
            ----
            """;
        ResultView resultView = new ResultView(carsPosition);
        //when
        String result = resultView.display();
        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("display 결과 테스트")
    void display_0_음수_무시() {
        //given
        List<Car> carsPosition = List.of(
            new Car(new Position(-1)),
            new Car(new Position(0)),
            new Car(new Position(4)),
            new Car(new Position(5))
        );
        String expected = """
                        
                        
            ----
            -----
            """;
        ResultView resultView = new ResultView(carsPosition);
        //when
        String result = resultView.display();
        //then
        assertThat(result).isEqualTo(expected);
    }
}
