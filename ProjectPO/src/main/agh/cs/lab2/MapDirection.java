package main.agh.cs.lab2;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    @Override
    public String toString() {
        switch (this) {
            case EAST:
                return "Wschod";
            case WEST:
                return "Zachod";
            case NORTH:
                return "Polnoc";
            case SOUTH:
                return "Poludnie";
            default:
                return null;
        }
    }

    public MapDirection next() {
        switch (this) {
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            case SOUTH:
                return WEST;
            case NORTH:
                return EAST;
            default:
                return null;
        }
    }

    public MapDirection previous() {
        switch (this) {
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case NORTH:
                return WEST;
            default:
                return null;
        }
    }

    public Vector2D toUnitVector() {
        switch (this) {
            case EAST:
                return new Vector2D(1, 0);
            case WEST:
                return new Vector2D(-1, 0);
            case SOUTH:
                return new Vector2D(0, -1);
            case NORTH:
                return new Vector2D(0, 1);
            default:
                return null;
        }
    }
}
