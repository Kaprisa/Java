import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task6 {
    private static String str = "";
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.java"))) {
            stream
                    .filter(line -> line.contains("abstract") && !line.contains("class"))
                    .map(line -> line.replaceFirst(".*abstract\\s+\\w{1,}\\s{1,}", "").trim() + "\n")
                    .forEach(line -> str += line);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\javaTask6Res.txt"))) {
            writer.write(str);
        }
    }
}
