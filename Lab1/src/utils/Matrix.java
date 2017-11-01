package utils;

public class Matrix {
    public int[][] input(String msg1, String msg2) {
        int size1, size2;
        Fills inp = new Fills();
        size1 = inp.fillInt(msg1);
        size2 = inp.fillInt(msg2);
        return inp.fillMatrix(size1, size2);
    }
    public int[][] input() {
        return input("Введите колличество строк матрицы", "Введите колличество столбцов матрицы");
    }
    public int[][] inputSquare(String msg) {
        int size;
        Fills inp = new Fills();
        size = inp.fillInt(msg);
        return inp.fillMatrix(size);
    }
    public int[][] inputSquare() {
        return inputSquare("Введите размер матрицы");
    }
    public void print(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i ++) {
            for (int j = 0; j < matrix[i].length ; j ++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
    public int[][] multiply(int[][] matrix1, int[][] matrix2) throws NoMathMatrixException {
        if (matrix1[0].length != matrix2.length) {
            throw new NoMathMatrixException("Колличество столбцов первой матрицы должно быть равно колличеству строк второй матрицы");
        }
        int[][] matrix3 = new int[matrix1.length][matrix2[0].length];
        for (int i = 0 ; i < matrix1.length ; i ++) {
            for (int j = 0 ; j < matrix2[0].length ; j ++) {
                int sum = 0;
                for (int k = 0 ; k < matrix2.length; k ++ ) {
                    sum += matrix1[i][k]*matrix2[k][j];
                }
                matrix3[i][j] = sum;
            }

        }
        return matrix3;
    }
}
