public class Task2 {
    public static void main(String[] args) {
        String[] words = args[0].toLowerCase().split("[\\,.\\s]");
        String res = "";
        for (int i = 0 ; i < words.length; i ++) if (isPalindrome(words[i])) res += words[i] + " ";
        System.out.println(res);
    }
    public static boolean isPalindrome(String text) {
        boolean y = true;
        for (int i = 0 ; i < text.length() ; i ++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                y = false;
                break;
            }
        }
        return y;
    }
}
