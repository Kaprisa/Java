package toys;

public abstract class PlushToy extends Toy {
    private String color;
    @Override
    public String getCategory() {
        return "Плюшевая игрушка";
    }

    public PlushToy(String name, int weight, int price, String color) {
        super(name, weight, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "PlushToy{" +
                "price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", name='" + this.getName() + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
