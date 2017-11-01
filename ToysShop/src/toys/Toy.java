package toys;

import utils.Buyable;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Toy implements Buyable, Comparator<Toy>, Serializable {
    private int price;
    private int weight;
    private String name;
    private String category;

    public abstract String getCategory();

    public Toy(String name, int weight, int price){
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public void buy() {
        System.out.println("Ваша покупка " + this.getFullName());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return this.getCategory() + " " + this.getName();
    }

    @Override
    public String toString() {
        return "Toy{" +
                "price=" + price +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (price != toy.price) return false;
        if (weight != toy.weight) return false;
        if (name != null ? !name.equals(toy.name) : toy.name != null) return false;
        return category != null ? category.equals(toy.category) : toy.category == null;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + weight;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    public boolean compareType(String type) {
        return this.getClass().toString().toLowerCase().contains(type);
    }

    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
