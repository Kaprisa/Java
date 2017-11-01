package toys;

public class Ken extends DollToy {
    @Override
    public String getCategory() {
        return "Кен";
    }

    public Ken(String name, int weight, int price, String hairColor) {
        super(name, weight, price, hairColor);
    }
}
