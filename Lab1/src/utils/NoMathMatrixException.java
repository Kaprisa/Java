package utils;

public class NoMathMatrixException extends Exception {
    public NoMathMatrixException(String message) {
        super(message);
    }

    public NoMathMatrixException() {
        this("Матрицы не совместны");
    }
}
