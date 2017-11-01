import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task7 {
    private static String str = "";
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.java"))) {
            stream
                    .filter(line -> line.matches("((private|public|protected)\\s){0,1}(final\\s+){0,1}.*\\s+[^\\.]+\\s+=.+;"))
                    .map(line -> line.trim().replaceFirst("((private|public|protected)\\s){0,1}(final\\s+)?\\w*\\s+", "").replaceFirst(";", "").trim() + "\n")
                    .forEach(line -> str += line);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\javaTask7Res.txt"))) {
            writer.write(str);
        }
    }
}
