package src.main.java.marsrover;

import lombok.Data;
import src.main.java.communication.Command;
import src.main.java.communication.Position;
import src.main.java.communication.Range;

@Data
public class Communication {
    private Range range;
    private Position position;
    private Command command;

    public Communication(Range range, Position position, Command distance) {
        this.range = range;
        this.position = position;
        this.command = distance;
    }
}
