import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.marsrover.Communication;
import src.main.java.marsrover.MarsRover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    private Communication communication;
    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        communication = new Communication(
                new Range(20, 20),
                new Position(new Point(0, 0), Direction.E),
                new Command(RotationType.LEFT, 5));
        marsRover = new MarsRover(communication);
    }

    @Test
    public void isMatchReturnWhenExecute() {
        assertEquals(communication, marsRover.execute());
    }

    @Test
    void isRotateCorrect() {
        assertEquals(Direction.N, marsRover.execute().getPosition().getDirection());
        assertEquals(Direction.W, marsRover.execute().getPosition().getDirection());
        assertEquals(Direction.S, marsRover.execute().getPosition().getDirection());
        assertEquals(Direction.E, marsRover.execute().getPosition().getDirection());
    }

    @Test
    void isMoveCorrect() {
        assertEquals(5, marsRover.execute().getPosition().getPoint().getY());
    }

    @Test
    void isExecuteTwiceCorrect() {
        marsRover.execute();
        assertEquals(5, marsRover.execute().getPosition().getPoint().getY());
        assertEquals(-5, marsRover.execute().getPosition().getPoint().getX());
    }

}
