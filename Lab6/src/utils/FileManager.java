package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static String workingDir = System.getProperty("user.dir");

    public static String getFileContent(String fileName) {
        String str = "";
        try(FileReader reader = new FileReader(fileName))
        {
            int c;
            while((c=reader.read())!=-1){

                str += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return str;
    }

    public static  void writeToFile(String fileName, String content) {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            writer.write(content);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
