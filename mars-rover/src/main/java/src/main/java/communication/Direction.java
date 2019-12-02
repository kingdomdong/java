package src.main.java.communication;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Direction {

    N,
    W,
    S,
    E;

    public static Direction getDirectionByRelatedIndex(Direction currentDirection, Integer indexRevision) {
        for (Direction direction : values())
            if (currentDirection == direction)
                return values()[(direction.ordinal() + indexRevision) % values().length];
        return currentDirection;
    }

}
