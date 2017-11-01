package toys;

public class PlushBeer extends PlushToy {
    public PlushBeer(String name, int weight, int price, String color) {
        super(name, weight, price, color);
    }

    @Override
    public String getCategory() {
        return "Плюшевый медведь";
    }


}
