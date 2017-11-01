import function.Function;

public class Main {
    public static void main(String[] args) {
        Function f = new Function("x+4");
        f.setX(2);
        System.out.println(f.findMax(1, 10));
    }
}
