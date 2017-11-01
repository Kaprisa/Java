public class Task7 {
    public static void main(String[] args) {
        String[] words = args[0].split("\"");
        String res = "";
        for (int i = 1 ; i < words.length; i += 2) {
            res += words[i] + " ";
        }
        System.out.println(res);
    }
}
