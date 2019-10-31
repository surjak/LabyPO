package main.agh.cs.lab5;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;
import main.agh.cs.lab4.IWorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Car> cars = new ArrayList<>();

    @Override
    public boolean place(Car car) {

        if (!this.isOccupied(car.getPosition())) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int carSize = cars.size();
        for (int i = 0; i < directions.length; i++) {
            cars.get(i % carSize).move(directions[i]);
            System.out.println();
            System.out.print(cars.get(i % carSize).getPosition());
            System.out.print(cars.get(i % carSize));
            System.out.println(this);


        }

    }

    @Override
    public boolean isOccupied(Position position) {
        AtomicBoolean canPlace = new AtomicBoolean(false);
        cars.forEach(car1 -> {
            if (car1.getPosition().equals(position)) {
                canPlace.set(true);
            }
        });

        return canPlace.get();
    }
}
