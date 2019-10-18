package main.agh.cs.lab4;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;

public interface IWorldMap {

    boolean canMoveTo(Position position);

    boolean place(Car car);

    void run(MoveDirection[] directions);

    boolean isOccupied(Position position);

    Object objectAt(Position position);
}
