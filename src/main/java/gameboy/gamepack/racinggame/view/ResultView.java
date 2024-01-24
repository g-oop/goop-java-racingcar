package gameboy.gamepack.racinggame.view;

import java.util.*;
import java.util.stream.Collectors;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.vo.RaceLog;
import gameboy.gamepack.racinggame.data.vo.CarStatus;

public class ResultView {

    public static void display(RaceResultDto result) {
        System.out.println(getRacePlayback(result.getRaceLogs()));
        System.out.println(getRaceResult(result.getWinners()));
    }

    private static String getRacePlayback(List<RaceLog> raceLogs) {
        return raceLogs.stream().map(ResultView::createResult).collect(Collectors.joining("\n"));
    }

    private static String createResult(RaceLog raceLog) {
        return raceLog.getStatuses().stream()
            .map(ResultView::createWheelMark)
            .collect(Collectors.joining("\n","", "\n"));
    }

    private static String createWheelMark(CarStatus status) {
        return status.getName() + ": " + "-".repeat(status.getPosition());
    }

    private static String getRaceResult(List<String> winners) {
        return winners.stream().collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }

}
