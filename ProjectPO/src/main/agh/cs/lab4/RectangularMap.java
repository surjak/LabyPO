package main.agh.cs.lab4;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RectangularMap implements IWorldMap {

    public int width;
    public int height;


    List<Car> cars = new ArrayList<>();

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
        AtomicBoolean canPlace = new AtomicBoolean(true);
        cars.forEach(car1 -> {
            if (car1.getPosition().equals(car.getPosition())) {
                canPlace.set(false);
            }
        });
        if (canPlace.get()) {
            cars.add(car);
        }
        return canPlace.get();
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

    @Override
    public Object objectAt(Position position) {
        return cars.stream().filter(car -> car.getPosition().equals(position)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Position(0, 0), new Position(width - 1, height - 1));

    }
}
