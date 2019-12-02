import org.junit.jupiter.api.Test;
import src.main.java.communication.Direction;
import src.main.java.communication.RotateType;
import src.main.java.controller.Rotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotationTest {

    @Test
    void isNorthWhenEastTurningLeft() {
        Direction currentDirection = Direction.E;
        RotateType rotateType = RotateType.L;
        assertEquals(Direction.N, new Rotation(currentDirection, rotateType).rotate());
    }

}
