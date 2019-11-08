package main.agh.cs.lab5;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;
import main.agh.cs.lab4.IWorldMap;
import main.agh.cs.lab6.IPositionChangeObserver;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Car> carsObjects = new LinkedList<>();
    protected Map<Position, Car> cars = new HashMap<>();

    @Override
    public boolean place(Car car) {

        if (!isOccupied(car.getPosition())) {
            cars.put(car.getPosition(), car);
            carsObjects.add(car);
            return true;
        } else
            throw new IllegalArgumentException("can't place car on this position: " + car.getPosition() + ", because this position is occupied");

    }

    @Override
    public void run(MoveDirection[] directions) {
        Car temp;
        for (int i = 0; i < directions.length; i++) {
            temp = carsObjects.get(i%carsObjects.size());
            temp.positionChanged(directions[i]);
        }

    }

    @Override
    public boolean isOccupied(Position position) {
        return cars.get(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        return cars.get(position);
    }

    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        Car car = cars.remove(oldPosition);
        cars.put(newPosition, car);
    }
}
