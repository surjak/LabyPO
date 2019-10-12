package agh.cs.lab3;

public class Car {

    private MapDirection direction = MapDirection.NORTH;
    private Position position = new Position(2, 2);

    @Override
    public String toString() {
        return
                "direction=" + direction +
                        ", position=" + position;
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
                if (position.x >= 0 && position.x <= 4 && position.y >= 0 && position.y <= 4) {
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                Position position1 = this.position.subtract(this.direction.toUnitVector());
                if (position1.x >= 0 && position1.x <= 4 && position1.y >= 0 && position1.y <= 4) {
                    this.position = this.position.subtract(this.direction.toUnitVector());
                }
                break;
        }
    }

}
