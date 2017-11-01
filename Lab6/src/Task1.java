import java.util.Scanner;
import utils.FileManager;


public class Task1 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку для замены");
        String toReplace = sc.nextLine();
        System.out.println("Введите замену");
        String replacement = sc.nextLine();
        String str = FileManager.getFileContent(FileManager.workingDir + "\\sampleFiles\\test.txt");
        str = str.replaceAll(toReplace, replacement);
        FileManager.writeToFile(FileManager.workingDir + "\\sampleFiles\\test.txt", str);
        System.out.println("Файл успешно перезаписан!");
    }

}
