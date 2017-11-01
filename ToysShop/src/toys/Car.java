package toys;

import utils.Direction;
import utils.Movable;

public class Car extends ElectronicToy implements Movable {
    private String color;
    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.LEFT;


    @Override
    public String getCategory() {
        return "Машина";
    }

    public Car(String name, int weight, int price, String batteries, String color) {
        super(name, weight, price, batteries);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move(int steps) {
        switch (direction) {
            case UP: y += steps;
            case DOWN: y -= steps;
            case LEFT: x -= steps;
            case RIGHT: x += steps;
        }
    }

    @Override
    public void turnRight() {
        switch (direction) {
            case UP: direction = Direction.RIGHT;
            case DOWN: direction = Direction.LEFT;
            case LEFT: direction = Direction.UP;
            case RIGHT: direction = Direction.DOWN;
        }
    }

    @Override
    public void turnLeft() {
        switch (direction) {
            case UP: direction = Direction.LEFT;
            case DOWN: direction = Direction.RIGHT;
            case LEFT: direction = Direction.DOWN;
            case RIGHT: direction = Direction.UP;
        }
    }

    @Override
    public String toString() {
        return "Car{ " +
                "price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", name='" + this.getName() + '\'' +
                ", color = '" + color + '\'' +
                ", batteries='" + this.getBatteries() + '\'' +
                ", x = " + x +
                ", y = " + y +
                ", direction = " + direction +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (x != car.x) return false;
        if (y != car.y) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return direction == car.direction;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
