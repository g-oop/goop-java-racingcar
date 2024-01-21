package gameboy.gamepack.racinggame.view;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;

public class ResultView {

    public static void display(RaceResultDto result) {
        System.out.println(result.getRaceResult());
    }

}
