package gameboy.gamepack.racinggame.data.vo;

import java.util.*;

public class RaceLog {

    private List<CarStatus> statuses;

    public RaceLog(List<CarStatus> statuses) {
        this.statuses = statuses;
    }

    public List<CarStatus> getStatuses() {
        return statuses;
    }

}
