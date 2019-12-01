package src.main.java.communication;

import lombok.Data;

@Data
public class Command {
    private RotationType rotationType;
    private int distance;

    public Command(RotationType rotation, int distance) {
        this.rotationType = rotation;
        this.distance = distance;
    }
}
