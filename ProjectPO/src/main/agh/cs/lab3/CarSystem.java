package main.agh.cs.lab3;

import main.agh.cs.lab4.IWorldMap;
import main.agh.cs.lab4.RectangularMap;

import java.util.Arrays;

public class CarSystem {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        Object obj = map.objectAt(new Position(2,2));
        System.out.println((Car)obj);
        map.place(new Car(new Position(3, 4), map));
        map.run(directions);
        System.out.println();
        System.out.println(map);
    }
}
