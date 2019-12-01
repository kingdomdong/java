package src.main.java.marsrover;

import lombok.Data;
import src.main.java.communication.Direction;
import src.main.java.communication.Movement;
import src.main.java.communication.Point;
import src.main.java.communication.Rotation;

@Data
public class MarsRover {

    private Communication communication;

    public MarsRover(Communication communication) {
        this.communication = communication;
    }

    public Communication execute() {
        rotate().move();
        return communication;
    }

    private MarsRover rotate() {
        Direction direction = buildRotation().rotate();
        communication.getPosition().setDirection(direction);
        return this;
    }

    private MarsRover move() {
        Point point = buildMovement().move();
        communication.getPosition().setPoint(point);
        return this;
    }

    private Rotation buildRotation() {
        return new Rotation(
                communication.getPosition().getDirection(),
                communication.getCommand().getRotationType()
        );
    }

    private Movement buildMovement() {
        return new Movement(
                communication.getPosition(),
                communication.getCommand().getDistance()
        );
    }

}
