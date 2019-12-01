import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovementTest {

    @Test
    void isMoveNorthCorrect() {
        Position position = new Position(new Point(0, 0), Direction.N);
        Movement movement = new Movement(position, 5);
        assertEquals(5, movement.move().getY());
        assertEquals(0, movement.move().getX());
    }

    @Test
    void isMoveEastCorrect() {
        Position position = new Position(new Point(0, 0), Direction.E);
        Movement movement = new Movement(position, 5);
        assertEquals(5, movement.move().getX());
        assertEquals(0, movement.move().getY());
    }

}
