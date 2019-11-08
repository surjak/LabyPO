package main.agh.cs.lab3;

import main.agh.cs.lab4.IWorldMap;
import main.agh.cs.lab4.RectangularMap;
import main.agh.cs.lab5.HayStack;
import main.agh.cs.lab5.UnboundedMap;

import java.util.ArrayList;
import java.util.Arrays;

public class CarSystem {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionParser().parse(args);
//        f b r l f f r r f f f f f f f f
            IWorldMap map = new RectangularMap(10, 5);
            map.place(new Car(map));

            Object obj = map.objectAt(new Position(2, 2));
            System.out.println((Car) obj);
            map.place(new Car(new Position(1, 4), map));
            map.run(directions);
            System.out.println();
            System.out.println(map);
            //fbrlff
            //second map

            ArrayList<HayStack> hayStackArrayList = new ArrayList<HayStack>();
            hayStackArrayList.add(new HayStack(new Position(-4, -4)));
            hayStackArrayList.add(new HayStack(new Position(7, 7)));
            hayStackArrayList.add(new HayStack(new Position(3, 6)));
            hayStackArrayList.add(new HayStack(new Position(2, 0)));
            IWorldMap map1 = new UnboundedMap(hayStackArrayList);
            map1.place(new Car(map1));

//            Object obj1 = map1.objectAt(new Position(2, 2));
            map1.place(new Car(new Position(3, 4), map1));
//            map1.place(new Car(new Position(2, 0), map1));

            map1.run(directions);
            System.out.println();
            System.out.println(map1);

        }catch (IllegalArgumentException ex){
            System.out.println("ERROR: "+ex.getMessage());
        }

    }
}
