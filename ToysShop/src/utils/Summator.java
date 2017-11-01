package utils;

public class Summator {
    public static <T extends Number> double count(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    public static int count(int[] array) {
        int sum = 0;
        for (int i = 0 ; i < array.length; i ++) {
            sum += array[i];
        }
        return sum;
    }
}



