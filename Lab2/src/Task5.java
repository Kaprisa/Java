import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        String[] words = args[0].split("[\\,.\\s]");
        String res = "";
        String tmp;
        for (int i = words.length - 1 ; i > 0 ; i --) {
            for (int j = 0 ; j < i ; j ++) {
                if (words[j].compareTo(words[j + 1]) > 0) {
                    tmp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = tmp;
                }
            }
        }
        for (int i = 0 ; i < words.length ; i ++) res += words[i] + " ";
        System.out.println(res);
    }
}
