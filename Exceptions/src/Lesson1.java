import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1 {
    public static void main(String[] args) {
        int x = 98;
        int y = 0;
        System.out.println(dicideBYL(x, y));
        System.out.println(divideEAFP(x, y));
        x = getIntLBYL();
        System.out.println("x = " + x);
        x = getIntEAFP();
        System.out.println("x = " + x);
    }
    private static int dicideBYL(int x, int y) {
        if(y !=0 ) {
            return x/y;
        } else {
            return 0;
        }
    }
    private static int divideEAFP(int x, int y) {
        try {
            return x/y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }
    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private static int getIntLBYL() {
        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Введите целое число");
        String input = sc.next();
        for (int i = 0 ; i < input.length(); i ++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }
    private static int getIntEAFP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число");
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
