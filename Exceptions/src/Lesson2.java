import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        try {
            System.out.println(divide());
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Невозможно выполнить деление");
        }

    }
    private static int divide() {
        int x, y;
        //try {
            x = getInt();
            y = getInt();
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("Неверный ввод");
//        }
       System.out.println("x = " + x + ", y = " + y);
//        try {
            return x/y;
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("Нельзя делить на 0!");
//        }

    }
    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число");
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Введите число, используя тольк цифры");
            }
        }

    }
}
