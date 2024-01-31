package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Position;

public interface Movement {

    Position move(Position position);
}
