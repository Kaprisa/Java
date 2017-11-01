import utils.Matrix;

public class Task2 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = matrix.inputSquare();
        int[][] sumArray = new int[matrix1.length][2];
        int i, j;
        int[] h = new int[2];
        int[] t = new int[matrix1.length];
        for (i = 0; i < matrix1.length ; i ++) {
            sumArray[i][1] = i;
            for (j = 0 ; j < matrix1.length; j ++) sumArray[i][0] += matrix1[i][j];
        }
        for (i = matrix1.length - 1 ; i > 0 ; i --) {
            for (j = 0 ; j < i ; j ++) {
                if (sumArray[j][0] > sumArray[j + 1][0]) {
                    h = sumArray[j];
                    sumArray[j] = sumArray[j+1];
                    sumArray[j+1] = h;
                    t = matrix1[j];
                    matrix1[j] = matrix1[j+1];
                    matrix1[j+1] = t;
                }
            }
        }
        System.out.println("Ваша матрица с упорядоченными строками по возрастанию сумм их элементов:");
        matrix.print(matrix1);
    }
}
