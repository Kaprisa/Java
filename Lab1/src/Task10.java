import utils.Fills;

public class Task10 {
    public static void main(String[] args) {
        Fills filler = new Fills();
        int linesCount = filler.fillInt("Введите колличество отрезков, составляющих ломаную");
        int[][] brokenLine = new int[linesCount][4];
        for (int i = 0 ; i < linesCount ; i ++) {
            brokenLine[i] = filler.fillArray(4, "Введите 4 числа - координаты " + i + " отрезка");
        }
        double brokenLineLength = 0;
        for (int i = 0 ; i < linesCount; i ++) {
            brokenLineLength += Math.sqrt(Math.pow(brokenLine[i][0] - brokenLine[i][2], 2) + Math.pow(brokenLine[i][1] -brokenLine[i][3], 2));
        }
        System.out.println("Длина линии примерно составила " + String.format("%.2f",brokenLineLength));
    }
}
