package shop;

import toys.Toy;
import toys.ToysList;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ToysShop extends Shop {

    private ToysList toys;

    public ToysShop(String name, String address, int square) {
        super(name, address, square);
        this.toys = new ToysList();
    }

    public void buy(int money, Toy toy) {
        //if (!toys.have(toy)) throw new NoSuchElementException("Такой игрушки не нашлось:(");
        if (!toys.have(toy)) {
            System.out.println("Такой игрушки не нашлось:(");
            return;
        }
        toy.buy();
        this.toys.remove(toy);
        super.check(money, toy.getPrice());
    }

    public void buy(int money, String toyType) {
        if (!toys.have(toyType)) throw new NoSuchElementException("Такой игрушки не нашлось:(\n");
        //Toy t
        //this.toys.remove(toy);
        //super.check(money, toy.getPrice());
        //Toy t = toys.stream();
    }
    public void addToy(Toy toy) {
        this.toys.add(toy);
        this.addQ();
   }

    public void addToys(ArrayList<Toy> toys) {
        this.toys.add(toys);
    }

   public String getToys() {
        return this.toys.getAll();
   }
   public String getToys(String type) {
        return this.toys.getAll(type);
   }

   public void sortToysByPrice() {
        this.toys.sortByPrice();
   }
}
