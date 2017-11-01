import utils.Matrix;

public class Task3 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = matrix.inputSquare();
        int[][] sumArray = new int[matrix1.length][2];
        int i, j, t;
        int[] h = new int[2];
        for (i = 0; i < matrix1.length ; i ++) {
            for (j = 0; j < matrix1.length; j++) {
                sumArray[i][0] += matrix1[j][i];
            }
        }
        for (i = matrix1.length - 1 ; i > 0 ; i --) {
            for (j = 0 ; j < i ; j ++) {
                if (sumArray[j][0] > sumArray[j + 1][0]) {
                    h = sumArray[j];
                    sumArray[j] = sumArray[j+1];
                    sumArray[j+1] = h;
                    for (int k = 0; k < matrix1.length; k ++) {
                        t = matrix1[k][j];
                        matrix1[k][j] = matrix1[k][j+1];
                        matrix1[k][j+1] = t;
                    }
                }
            }
        }
        System.out.println("Ваша матрица с упорядоченными столбцами по возрастанию сумм их элементов:");
        matrix.print(matrix1);
    }
}