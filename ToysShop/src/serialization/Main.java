package serialization;

import toys.Barbi;
import toys.Car;
import toys.PlushBeer;
import toys.Toy;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static String workingDir = System.getProperty("user.dir");

    public static void main(String[] args) {

        //Object
        String fileName = workingDir + "/files/toy.bin";
        Car car = new Car("Fast", 200, 1100, "energizer", "red");
        car.move(10);
        car.turnRight();
        car.move(5);

        try {
            Serializator.serialize(car, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Toy toy = null;

        try {
            toy = (Toy) Serializator.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("car Object::"+car);
        System.out.println("toy Object::"+toy);
        System.out.println(toy.equals(car) + "\n\n\n");


        //Array of objects

        Toy[] toys = {new PlushBeer("Tom", 200, 1100, "brown"), new Barbi("Mary", 200, 1100, "brown")};
        fileName = fileName.replaceFirst("toy", "toys");
        try {
            Serializator.serialize(toys, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Toy[] toys2 = null;

        try {
            toys2 = (Toy[]) Serializator.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(toys2));
    }
}
