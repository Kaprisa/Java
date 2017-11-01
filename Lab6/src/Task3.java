import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task3 {
    public static String str = "";
    public static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.html"))) {
            stream
                    .filter(line -> line.matches(".*<h[1-6]{1}>[^(</h)]*</h[1-6]{1}>.*"))
                    .map(line -> {
                        line = line.trim();
                        String newLine = "";
                        if (line.startsWith("<h2")) newLine += "\t\t";
                        if (line.startsWith("<h3")) newLine += "\t\t\t";
                        if (line.startsWith("<h4")) newLine += "\t\t\t\t";
                        if (line.startsWith("<h5")) newLine += "\t\t\t\t\t";
                        if (line.startsWith("<h6")) newLine += "\t\t\t\t\t\t";
                        return newLine + line.replaceAll("</{0,1}h[1-6]{1}>", "") + "\n";
                    })
                    .forEach(line -> str += line);
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\htmlRes.txt"))) {
            writer.write(str);
        }
    }
}
