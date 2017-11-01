import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task2 {
    public static String str = "";
    public static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        //String str = "";
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.latex"))) {
            stream
                    .filter(line -> line.matches(".{1}((sub){0,2}section|charapter){1}.*"))
                    .map(line -> {
                        line = line.trim();
                        String title = line.substring(line.indexOf("{") + 1, line.length() - 1) + "\n";
                        if (line.contains("subsub")) return "\t\t\t" + title;
                        if (line.contains("sub")) return "\t\t" + title;
                        if (line.contains("section")) return "\t" + title;
                        return title;
                    })
                    .forEach(line -> str += line);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\latexRes.txt"))) {
            writer.write(str);
        }
    }
}
