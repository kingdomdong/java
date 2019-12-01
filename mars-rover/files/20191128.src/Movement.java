package src.main.java.communication;

public class Movement {
    private Position position;
    private int distance;

    public Movement(Position position, int distance) {
        this.position = position;
        this.distance = distance;
    }

    public Point move() {
        if (Direction.N == position.getDirection())
            position.getPoint().setY(position.getPoint().getY() + distance);
        if (Direction.W == position.getDirection())
            position.getPoint().setX(position.getPoint().getX() - distance);
        if (Direction.S == position.getDirection())
            position.getPoint().setY(position.getPoint().getY() - distance);
        if (Direction.E == position.getDirection())
            position.getPoint().setX(position.getPoint().getX() + distance);
        return position.getPoint();
    }

}
