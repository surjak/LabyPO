package main.agh.cs.lab3;

import java.util.Objects;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position position) {
        if (this.x <= position.x && this.y <= position.y)
            return true;
        else
            return false;
    }

    public boolean larger(Position position) {
        if (this.x >= position.x && this.y >= position.y)
            return true;
        else
            return false;
    }

    public Position upperRight(Position position) {
        int x;
        int y;
        if (this.x < position.x)
            x = position.x;
        else
            x = this.x;
        if (this.y < position.y)
            y = position.y;
        else
            y = this.y;
        Position point = new Position(x, y);
        return point;
    }

    public Position lowerLeft(Position position) {
        int x;
        int y;
        if (this.x > position.x)
            x = position.x;
        else
            x = this.x;
        if (this.y > position.y)
            y = position.y;
        else
            y = this.y;
        Position point = new Position(x, y);
        return point;
    }

    public Position add(Position position) {
        return new Position(this.x + position.x, this.y + position.y);
    }

    public Position subtract(Position position) {
        return new Position(this.x - position.x, this.y - position.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
