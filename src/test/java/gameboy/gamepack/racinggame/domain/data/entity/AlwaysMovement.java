package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Position;

public class AlwaysMovement implements Movement {

    @Override
    public Position move(Position position) {
        return position.addOne();
    }
}
