package toys;

public class DollToy extends Toy {
    private String hairColor;
    @Override
    public String getCategory() {
        return "Кукла";
    }

    public DollToy(String name, int weight, int price, String hairColor) {
        super(name, weight, price);
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return "DollToy{" +
                "price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", name='" + this.getName() + '\'' +
                ", hairColor='" + hairColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DollToy dollToy = (DollToy) o;

        return hairColor != null ? hairColor.equals(dollToy.hairColor) : dollToy.hairColor == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        return result;
    }
}
