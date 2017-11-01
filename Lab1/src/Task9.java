import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("Введите колличество точек вашей плоскости");
        int pointsCount = S.nextInt();
        double[][] points = new double[pointsCount][2];
        for (int i = 0 ; i < pointsCount ; i ++) {
            System.out.println("Введите " + (i + 1) + " точку");
            points[i][0] = S.nextFloat();
            points[i][1] = S.nextFloat();
        }
        double[] point = new double[2];
        System.out.println("Введите точку, для поиска максимального расстояния");
        point[0] = S.nextDouble();
        point[1] = S.nextDouble();
        double max = 0;
        double dist;
        int num = 0;
        for (int i = 0 ; i < pointsCount; i ++) {
            dist = Math.sqrt(Math.pow(points[i][0] - point[0], 2) + Math.pow(points[i][1] - point[1], 2));
            if (dist > max) {
                max = dist;
                num = i;
            }
        }
        System.out.println("Максимальное расстояние до вашей точки от точки (" + points[num][0] + " ," + points[num][1] + "). Оно примерно составило " + String.format("%.2f", max));
    }
}
