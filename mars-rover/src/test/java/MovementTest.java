import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.communication.Direction;
import src.main.java.communication.Point;
import src.main.java.communication.Position;
import src.main.java.controller.Movement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementTest {

    @Test
    void isMoveNorthCorrect() {
        Movement movement = new Movement(new Position(new Point(0, 0), Direction.N), 5);
        assertEquals(0, movement.move().getX());
        assertEquals(5, movement.move().getY());
    }

    @Test
    void isMoveEastCorrect() {
        Movement movement = new Movement(new Position(new Point(0, 0), Direction.E), 5);
        assertEquals(5, movement.move().getX());
        assertEquals(0, movement.move().getY());
    }

    @Test
    void isMoveSouthCorrect() {
        Movement movement = new Movement(new Position(new Point(0, 0), Direction.S), 5);
        assertEquals(0, movement.move().getX());
        assertEquals(-5, movement.move().getY());
    }

    @Test
    void isMoveWestCorrect() {
        Movement movement = new Movement(new Position(new Point(0, 0), Direction.W), 5);
        assertEquals(-5, movement.move().getX());
        assertEquals(0, movement.move().getY());
    }

}
