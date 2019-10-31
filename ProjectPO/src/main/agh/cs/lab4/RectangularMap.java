package main.agh.cs.lab4;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;
import main.agh.cs.lab5.AbstractWorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public int width;
    public int height;



    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (!isOccupied(position) && position.x >= 0 && position.x < width && position.y >= 0 && position.y < height) {
            return true;
        } else return false;
    }

    @Override
    public boolean place(Car car) {
     return super.place(car);
    }

    @Override
    public void run(MoveDirection[] directions) {

       super.run(directions);

    }

    @Override
    public boolean isOccupied(Position position) {
      return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Position position) {
        return super.objectAt(position);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Position(0, 0), new Position(width - 1, height - 1));

    }
}
