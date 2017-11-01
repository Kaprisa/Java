package toys;

public class Barbi extends DollToy {
    @Override
    public String getCategory() {
        return "Барби";
    }
    public Barbi(String name, int weight, int price, String hairColor) {
        super(name, weight, price, hairColor);
    }


}
