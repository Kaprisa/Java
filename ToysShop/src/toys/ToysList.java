package toys;

import utils.Sized;

import java.util.ArrayList;
import java.util.Comparator;

public class ToysList implements Sized {

    private ArrayList<Toy> toys = new ArrayList<>();

    public int size() {
        return toys.size();
    }

    public boolean have(String type) {
        return toys.stream().anyMatch(toy -> toy.compareType(type));
    }

    public boolean have(Toy toy) {
        return toys.stream().anyMatch(toy::equals);
    }

    public void add(Toy toy) {
        this.toys.add(toy);
    }

    public void add(ArrayList<Toy> toys) {
        this.toys.addAll(toys);
    }

    public void sortByPrice() {
        sortByPrice(1);
    }

    public void sortByPrice(int order) {
        Comparator<Toy> c = (o1, o2) -> o1.getPrice() - o2.getPrice();
        if (order == 1) toys.sort(c);
        else toys.sort(c.reversed());
    }

   public void remove(Toy toy) {
        this.toys.remove(toy);
   }

    public String  getAll() {
        return toys.stream().map(e -> e.getFullName() + "\n").reduce("", String::concat);
    }

    public String getAll(String type) {
        return toys.stream().filter(toy -> toy.compareType(type)).map(e -> e.getFullName() + "\n").reduce("", String::concat);
    }

}
