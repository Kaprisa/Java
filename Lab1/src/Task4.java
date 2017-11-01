import utils.Matrix;

public class Task4 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = matrix.inputSquare();
        int size = matrix1.length;
        int[] sumArray = new int[(size * 2) - 2];
        int i, j;
        for (i = 0 ; i < size - 1; i ++) {
            for (j = 0 ; j <= i ; j ++) {
                sumArray[i] += matrix1[j][i - j];
                sumArray[size - 1 + i] += matrix1[size - 1 - j][size - 1 - i + j];
            }
        }
        int min = sumArray[0];
        for (i = 1; i < sumArray.length; i ++) {
           if (sumArray[i] < min ) min = sumArray[i];
        }
        System.out.print("Минимум среди сумм элементов диагоналей, параллельных побочной диагонали вашей матрицы равен " + min);
    }
}

