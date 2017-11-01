package utils;

import java.util.Scanner;

public class Fills {
    Scanner S = new Scanner(System.in);
    public int[][] fillMatrix(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите строку из " + size + " целых чисел, разделенных пробелом");
            for ( int j = 0; j < size; j++) arr[i][j] = S.nextInt();
        }
        return arr;
    }
    public int[][] fillMatrix(int size1, int size2) {
        int[][] arr = new int[size1][size2];
        for (int i = 0; i < size1; i++) arr[i] = fillArray(size2, "Введите строку из " + size2 + " целых чисел, разделенных пробелом");
        return arr;
    }
    public int[] fillArray(int size, String str) {
        int[] arr = new int[size];
        if (str != "") {
            System.out.println(str);
        }
        for ( int i = 0; i < size; i ++) arr[i] = S.nextInt();
        return arr;
    }
    public int[] fillArray(int size) {
        return fillArray(size, "Введите строку из " + size + " целых чисел, разделенных пробелом");
    }
    public int fillInt(String str) {
        System.out.println(str);
        Scanner S = new Scanner(System.in);
        return S.nextInt();
    }
    public int fillInt() {
        return fillInt("Введите число");
    }
}
