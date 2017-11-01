import utils.Matrix;
import utils.NoMathMatrixException;

public class Task8 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = matrix.input("Введите колличество строк первой матрицы", "Введите колличество солбцов первой матрицы");
        int[][] matrix2 = matrix.input("Введите колличество строк второй матрицы", "Введите колличество солбцов второй матрицы");
        try {
            int[][] matrix3 = matrix.multiply(matrix1, matrix2);
            System.out.println("Результат умножения матриц:");
            matrix.print(matrix3);
        } catch (NoMathMatrixException e) {
            System.out.println(e.getMessage());
        }
    }
}
