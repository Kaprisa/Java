import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Task5 {
    private static String fileStr = "";
    private static String workingDir = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(workingDir + "\\sampleFiles\\test.java"))) {
            stream.forEach(line -> fileStr += line.trim() + "\n");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(workingDir + "\\sampleFiles\\javaTask5Res.txt"))) {
            String[] arr = fileStr.split("\n");
            fileStr = "";
            String clStr = "";
            for (int i = 0 ; i < arr.length ; i ++) {
                if (arr[i].contains("class")) {
                    clStr += arr[i].replaceFirst(".*class\\s+", "").replaceAll("\\{.*", "").trim() + ",";
                    arr[i] = "";
                }
            }
            String[] classes = clStr.split(",");
            for (String anArr : arr) {
                for (String aClass : classes) {
                    if (anArr.matches("((private|public|protected)\\s){0,1}" + aClass + ".*")) {
                        fileStr += anArr.replaceFirst("(private|public|protected)\\s*", "").replaceFirst("\\{", "") + "\n";
                    }
                }
            }
            writer.write(fileStr);
        }
    }
}
