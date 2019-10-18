package main.agh.cs.lab2;

import java.util.Objects;

public class Vector2D {
    public final int x;
    public final int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Vector2D vector2D) {
        if (this.x <= vector2D.x && this.y <= vector2D.y)
            return true;
        else
            return false;
    }

    public boolean larger(Vector2D vector2D) {
        if (this.x >= vector2D.x && this.y >= vector2D.y)
            return true;
        else
            return false;
    }

    public Vector2D upperRight(Vector2D vector2D) {
        int x;
        int y;
        if (this.x < vector2D.x)
            x = vector2D.x;
        else
            x = this.x;
        if (this.y < vector2D.y)
            y = vector2D.y;
        else
            y = this.y;
        Vector2D point = new Vector2D(x, y);
        return point;
    }

    public Vector2D lowerLeft(Vector2D vector2D) {
        int x;
        int y;
        if (this.x > vector2D.x)
            x = vector2D.x;
        else
            x = this.x;
        if (this.y > vector2D.y)
            y = vector2D.y;
        else
            y = this.y;
        Vector2D point = new Vector2D(x, y);
        return point;
    }

    public Vector2D add(Vector2D vector2D) {
        return new Vector2D(this.x + vector2D.x, this.y + vector2D.y);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return new Vector2D(this.x - vector2D.x, this.y - vector2D.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2D)) return false;
        Vector2D vector2D = (Vector2D) o;
        return x == vector2D.x &&
                y == vector2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
