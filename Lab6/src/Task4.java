import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task4 {
    private static String str = "";
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.java"))) {
            stream
                    .filter(line -> line.contains("void"))
                    .map(line -> line.replaceFirst(".*void", "").replaceAll("\\{.*", "").trim() + "\n")
                    .forEach(line -> str += line);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\javaTask4Res.txt"))) {
            writer.write(str);
        }
    }
}
