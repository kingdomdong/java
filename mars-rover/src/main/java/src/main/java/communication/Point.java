package src.main.java.communication;

import lombok.Data;

@Data
public class Point {

    private int x;
    private int y;
    private Point point;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.point = point;
    }
}
