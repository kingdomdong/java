package src.main.java.communication;

import lombok.Data;

@Data
public class Position {
    private Point point;
    private Direction direction;

    public Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }
}
