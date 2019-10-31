package main.agh.cs.lab5;

import main.agh.cs.lab3.Car;
import main.agh.cs.lab3.MoveDirection;
import main.agh.cs.lab3.Position;
import main.agh.cs.lab4.IWorldMap;
import main.agh.cs.lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap {
    private List<HayStack> hayStackList;


    public UnboundedMap(List<HayStack> hayStackList) {
        this.hayStackList = hayStackList;
    }

    @Override
    public boolean canMoveTo(Position position) {
        if (!isOccupied(position)) {
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
        AtomicBoolean canPlace = new AtomicBoolean(false);
//        cars.forEach(car1 -> {
//            if (car1.getPosition().equals(position)) {
//                canPlace.set(true);
//            }
//        });
        canPlace.set(super.isOccupied(position));
        hayStackList.forEach(hayStack -> {
            if (hayStack.getPosition().equals(position)) {
                canPlace.set(true);
            }
        });

        return canPlace.get();
    }

    @Override
    public Object objectAt(Position position) {
        Object obj = cars.stream().filter(car -> car.getPosition().equals(position)).findFirst().orElse(null);
        if (Objects.equals(obj, null)) {
            obj = hayStackList.stream().filter(hayStack -> hayStack.getPosition().equals(position)).findFirst().orElse(null);

        }
        return obj;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        int xMax = cars.get(0).getPosition().x;
        int xMin = cars.get(0).getPosition().x;
        int yMax = cars.get(0).getPosition().y;
        int yMin = cars.get(0).getPosition().y;
        for (Car car : cars) {
            if (car.getPosition().x < xMin) {
                xMin = car.getPosition().x;
            } else if (car.getPosition().x > xMax) {
                xMax = car.getPosition().x;
            }
        }
        for (HayStack hayStack : hayStackList) {
            if (hayStack.getPosition().x < xMin) {
                xMin = hayStack.getPosition().x;
            } else if (hayStack.getPosition().x > xMax) {
                xMax = hayStack.getPosition().x;
            }
        }
        //y
        for (Car car : cars) {
            if (car.getPosition().y < yMin) {
                yMin = car.getPosition().y;
            } else if (car.getPosition().y > yMax) {
                yMax = car.getPosition().y;
            }
        }
        for (HayStack hayStack : hayStackList) {
            if (hayStack.getPosition().y < yMin) {
                yMin = hayStack.getPosition().y;
            } else if (hayStack.getPosition().y > yMax) {
                yMax = hayStack.getPosition().y;
            }
        }
        return mapVisualizer.draw(new Position(xMin, yMin), new Position(xMax, yMax));
    }
}
