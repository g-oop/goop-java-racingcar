package gameboy.gamepack.racinggame.view;

import java.util.*;
import java.util.stream.Collectors;

import gameboy.gamepack.racinggame.data.dto.RaceResultDto;
import gameboy.gamepack.racinggame.data.vo.RaceLog;
import gameboy.gamepack.racinggame.data.vo.CarStatus;

public class ResultView {

    public void display(RaceResultDto result) {
        System.out.println(getRacePlayback(result.getRaceLogs()));
        System.out.println(getRaceResult(result.getWinners()));

    }

    private String getRacePlayback(List<RaceLog> raceLogs) {
        return raceLogs.stream().map(this::createResult).collect(Collectors.joining());
    }

    public String createResult(RaceLog raceLog) {
        return raceLog.getStatuses().stream()
            .map(this::createWheelMark)
            .collect(Collectors.joining("\n","", "\n"));
    }

    private String createWheelMark(CarStatus status) {
        return status.getName() + ": " + "-".repeat(status.getPosition());
    }

    public String getRaceResult(Set<String> winners) {
        return winners.stream().collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }

}
