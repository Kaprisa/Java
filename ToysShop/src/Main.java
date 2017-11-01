import exceptions.BuyException;
import shop.ToysShop;
import toys.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ToysShop shop = new ToysShop("Hello", "Irkutsk", 500);
        shop.addToy(new PlushBeer("Misha", 100, 900, "white"));
        shop.addToy(new Barbi("Barbi", 100, 2000, "yellow"));
        shop.addToy(new Car("Metr", 500, 1000, "energizer","yellow"));

        Toy m = new PlushBeer("Tom", 200, 1100, "brown");
        shop.addToy(m);
        System.out.println(shop.getToys());

        try {
            shop.buy(1500, m);
        } catch (BuyException e) {
            System.out.println(e.getMessage());
        }


        try {
            shop.buy(500, m);
        } catch (BuyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(shop.getToys());

        shop.sortToysByPrice();
        System.out.println(shop.getToys());
        System.out.println(shop.getToys("electronic"));

        shop.addExpenses(1000, 4000, 500);
        System.out.println(shop.getExpensesInfo());
        System.out.println(shop.getProfitInfo()); //бизнес не выгоден

        ArrayList<Toy> toysList = new ArrayList<Toy>();
        Toy a = new Barbi("Mary", 200, 1100, "brown");
        Toy b = new Ken("Tom", 200, 1100, "black");
        Toy c = new PlushBeer("Jon", 200, 1100, "brown");
        Toy d = new Car("Fast", 200, 1100, "energizer", "red");
        Toy e = new Car("Rubby", 200, 1100,"energizer", "blue");
        Toy f = new PlushBeer("Tom", 200, 1100, "brown");
        Toy g = new PlushBeer("Sweet", 200, 1100, "pink");
        toysList.add(a);toysList.add(b);toysList.add(c);toysList.add(d);toysList.add(e);toysList.add(f);toysList.add(g);
        shop.addToys(toysList);
        System.out.println(shop.getToys());

        toysList.forEach(toy -> shop.buy(2000, toy));

        System.out.println(shop.getProfitInfo()); //теперь бизнес выгоден
    }
}
