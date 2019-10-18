package main.agh.cs.lab3;

import main.agh.cs.lab4.IWorldMap;

public class Car {

    private MapDirection direction = MapDirection.NORTH;
    private Position position = new Position(2, 2);
    private IWorldMap map;

    public Car(IWorldMap map) {
        this.map = map;
    }

    public Car(Position position, IWorldMap map) {
        this.position = position;
        this.map = map;
    }

    @Override
    public String toString() {
        switch (this.direction) {
            case NORTH:
                return "N";
            case WEST:
                return "W";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            default:
                return null;
        }
    }

    public void move(MoveDirection moveDirection) {
        switch (moveDirection) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                Position position = this.position.add(this.direction.toUnitVector());
                if (map.canMoveTo(this.position.add(this.direction.toUnitVector()))) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                Position position1 = this.position.subtract(this.direction.toUnitVector());
                if (map.canMoveTo(this.position.subtract(this.direction.toUnitVector()))) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
                break;
        }
    }

    public Position getPosition() {
        return this.position;
    }

}
