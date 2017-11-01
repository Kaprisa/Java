package toys;

public abstract class ElectronicToy extends Toy {

    private String batteries;

    @Override
    public String getCategory() {
        return "Электронная игрушка";
    }

    public ElectronicToy(String name, int weight, int price, String batteries) {
        super(name, weight, price);
        this.batteries = batteries;
    }

    public String getBatteries() {
        return batteries;
    }

    public void setBatteries(String batteries) {
        this.batteries = batteries;
    }

    @Override
    public String toString() {
        return "ElectronicToy{" +
                "price=" + this.getPrice() +
                ", weight=" + this.getWeight() +
                ", name='" + this.getName() + '\'' +
                "batteries='" + batteries + '\'' +
                '}';
    }
}
