import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task9 {
    private static int symbolsCount = 0, arraysCount = 0;
    private static char[] symbols = null;
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\charArr.ini"))) {
            stream
                    .forEach(line -> {
                        if (line.startsWith("symbolsCount")) symbolsCount = Integer.parseInt(line.replaceFirst("symbolsCount\\s+=\\s+", ""));
                        if (line.startsWith("arraysCount")) arraysCount = Integer.parseInt(line.replaceFirst("arraysCount\\s+=\\s+", ""));
                        if (line.startsWith("symbols")) symbols = line.replaceFirst("symbols\\s+=\\s+", "").replaceAll("\\W", "").toCharArray();
                    });
        }

        char[][] arr = new char[arraysCount][symbolsCount];

        int index;

        for (int i = 0 ; i < arraysCount; i ++) {
            for (int j = 0 ; j < symbolsCount ; j ++) {
                index = (int)Math.round(Math.random() * (symbols.length - 1));
                arr[i][j] = symbols[index];
            }
        }

        String arrStr = "";
        for (int i = 0 ; i < arraysCount; i ++) {
            arrStr += "[ ";
            for (int j = 0 ; j < symbolsCount - 1 ; j ++) {
                arrStr += arr[i][j] + ", ";
            }
            arrStr += arr[i][symbolsCount - 1] + " ]\n";
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\charArrRes.txt"))) {
            writer.write(arrStr);
        }
    }
}
