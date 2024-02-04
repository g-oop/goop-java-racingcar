package com.megazone.goop.racingcar.logic;

import java.text.MessageFormat;

public record CarDistance(String name, int position) {

    @Override
    public String toString() {
        return MessageFormat.format("{0} : {1}", name, "-".repeat(position));
    }
}
