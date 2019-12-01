package src.main.java.communication;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Direction {
    N("North"),
    E("East"),
    S("South"),
    W("West");
    String value;

    public static Direction getCoordinateByIndexRevision(Direction curCoordinate, Integer indexRevision) {
        for (Direction coordinate : values())
            if (coordinate == curCoordinate)
                return values()[(coordinate.ordinal() + indexRevision) % values().length];
        return curCoordinate;
    }
}
