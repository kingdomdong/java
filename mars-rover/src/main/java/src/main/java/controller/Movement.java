package src.main.java.controller;

import src.main.java.communication.Direction;
import src.main.java.communication.Point;
import src.main.java.communication.Position;

public class Movement {

    private Position position;
    private Integer distance;

    public Movement(Position position, Integer distance) {
        this.position = position;
        this.distance = distance;
    }

    public Point move() {
        if (position.getDirection() == Direction.N)
            return new Point(position.getPoint().getX(), position.getPoint().getY() + distance);

        if (position.getDirection() == Direction.E)
            return new Point(position.getPoint().getX() + distance, position.getPoint().getY());

        if (position.getDirection() == Direction.S)
            return new Point(position.getPoint().getX(), position.getPoint().getY() - distance);

        if (position.getDirection() == Direction.W)
            return new Point(position.getPoint().getX() - distance, position.getPoint().getY());

        return new Point(position.getPoint());
    }


}
