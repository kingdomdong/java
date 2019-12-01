import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.communication.Direction;
import src.main.java.communication.Rotation;
import src.main.java.communication.RotationType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotationTest {

    private Rotation rotationLeft;
    private Rotation rotationRight;

    @BeforeEach
    void setUp() {
        rotationLeft = new Rotation(Direction.E, RotationType.LEFT);
        rotationRight = new Rotation(Direction.E, RotationType.RIGHT);
    }

    @Test
    void isCorrectAfterTurnLeft() {
        assertEquals(Direction.N, rotationLeft.rotate());
        assertEquals(Direction.W, rotationLeft.rotate());
        assertEquals(Direction.S, rotationLeft.rotate());
        assertEquals(Direction.E, rotationLeft.rotate());
    }

    @Test
    void isCorrectAfterTurnRight() {
        assertEquals(Direction.S, rotationRight.rotate());
        assertEquals(Direction.W, rotationRight.rotate());
        assertEquals(Direction.N, rotationRight.rotate());
        assertEquals(Direction.E, rotationRight.rotate());
    }

}
