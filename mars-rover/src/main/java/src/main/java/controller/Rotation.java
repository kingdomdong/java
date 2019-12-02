package src.main.java.controller;

import src.main.java.communication.Direction;
import src.main.java.communication.RotateType;

public class Rotation {
    private Direction currentDirection;
    private RotateType rotateType;

    public Rotation(Direction currentDirection, RotateType rotateType) {
        this.currentDirection = currentDirection;
        this.rotateType = rotateType;
    }

    public Direction rotate() {
        return getDirectionAfterTurn(currentDirection, rotateType);
    }

    private Direction getDirectionAfterTurn(Direction currentDirection, RotateType rotateType) {
        Integer indexRivision = getIndexReversion(rotateType);
        return Direction.getDirectionByRelatedIndex(currentDirection, indexRivision);
    }

    private Integer getIndexReversion(RotateType rotateType) {
        if (rotateType == RotateType.L)
            return 3;
        if (rotateType == RotateType.R)
            return 1;
        return 0;
    }

}
