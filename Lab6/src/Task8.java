import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task8 {
    private static String str = "";
    private static int numbersCount = 0, arraysCount = 0, min = 0, max = 0;
    private static String type = "";
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\array.ini"))) {
            stream
                    .forEach(line -> {
                        if (line.startsWith("numbersCount")) numbersCount = Integer.parseInt(line.replaceFirst("numbersCount\\s+=\\s+", ""));
                        if (line.startsWith("arraysCount")) arraysCount = Integer.parseInt(line.replaceFirst("arraysCount\\s+=\\s+", ""));
                        if (line.startsWith("type")) type = line.replaceFirst("type\\s+=\\s+", "");
                        if (line.startsWith("min")) min = Integer.parseInt(line.replaceFirst("min\\s+=\\s+", ""));
                        if (line.startsWith("max")) max = Integer.parseInt(line.replaceFirst("max\\s+=\\s+", ""));
                    });
        }

        int[][] arr = new int[arraysCount][numbersCount];

        for (int i = 0 ; i < arraysCount; i ++) {
            for (int j = 0 ; j < numbersCount ; j ++) {
                arr[i][j] = (int)Math.round(min + Math.random()* (max - min));
            }
        }

        String arrStr = "";
        for (int i = 0 ; i < arraysCount; i ++) {
            arrStr += "[ ";
            for (int j = 0 ; j < numbersCount - 1 ; j ++) {
                arrStr += arr[i][j] + ", ";
            }
            arrStr += arr[i][numbersCount - 1] + " ]\n";
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\arraysRes.txt"))) {
            writer.write(arrStr);
        }
    }
}

