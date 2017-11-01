import utils.Matrix;

public class Task6 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = matrix.inputSquare("Введите размер меньшей матрицы");
        int[][] matrix2 = matrix.inputSquare("Введите размер большей матрицы");
        int iterCount = matrix2.length - matrix1.length + 1;
        String answer = "не является";
        o:
        for (int i = 0 ; i < iterCount; i ++) {
            for (int t = 0 ; t < iterCount ; t ++) {
                if (answer == "является") break o;
                answer = "является";
                nextCheck:
                for (int j = 0; j < matrix1.length; j++) {
                    for (int k = 0 ; k < matrix1.length ; k ++) {
                        if (matrix1[j][k] != matrix2[j + i][k + t]) {
                            answer = "не является";
                            break nextCheck;
                        }
                    }
                }
            }
        }
        System.out.println("Первая матрица " + answer + " клеткой второй матрицы.");
    }
}

