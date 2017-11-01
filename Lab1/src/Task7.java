import utils.Fills;

public class Task7 {

    public static void main(String[] args) {
        int size1, size2;
        Fills inp = new Fills();
        size1 = inp.fillInt("Введите длину меньшей последовательности");
        int[] arr1 = inp.fillArray(size1, "Введите последовательность из " + size1 + " целых чисел, разделенных пробелом");
        size2 = inp.fillInt("Введите длину большей последовательности");
        int[] arr2 = inp.fillArray(size2, "Введите последовательность из " + size2 + " целых чисел, разделенных пробелом");
        int iterCount = size2 - size1 + 1;
        String answer = "не входит";
        for (int i = 0 ; i < iterCount ; i ++) {
            if (answer == "входит") break;
            answer = "входит";
            for (int j = 0 ; j < size1 ; j ++) {
                if (arr1[j] != arr2[i + j]) {
                    answer = "не входит";
                    break;
                }
            }
        }
        System.out.print("Первая последовательность " + answer + " во вторую");
    }
}
