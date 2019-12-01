package src.main.java.communication;

public class Rotation {

    private Direction curDirection;
    private RotationType rotationType;

    public Rotation(Direction direction, RotationType rotationType) {
        this.curDirection = direction;
        this.rotationType = rotationType;
    }

    public Direction rotate() {
        return curDirection = Direction.getCoordinateByIndexRevision(curDirection, getIndexRevision(rotationType));
    }

    private Integer getIndexRevision(RotationType rotation){
        if (rotation == RotationType.LEFT)
            return 3;
        if (rotation == RotationType.RIGHT)
            return 1;
        return 0;
    }

}
