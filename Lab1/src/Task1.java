import utils.Fills;

public class Task1 {

    public static void main(String[] args) {
        int size;
        Fills inp = new Fills();
        size = inp.fillInt("Введите длину последовательности");
        int[] arr = inp.fillArray(size, "Введите последовательность из " + size + " целых чисел, разделенных пробелом");
        int d;
        String res =  "упорядочена";
        if (arr[0] > arr[1]) d = -1;
        else d = 1;
        for (int i = 0 ; i < arr.length - 1; i ++) {
            if (d*(arr[i] - arr[i + 1]) > 0) {
                res = "неупорядочена";
            }
        }
        System.out.print("Ваша последовательность " + res);
    }
}
