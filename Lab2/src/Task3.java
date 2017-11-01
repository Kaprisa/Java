public class Task3 {
    public static void main(String[] args) {
        String[] words = args[0].split("\\p{P}?[ \\t\\n\\r]+");
        int maxLength = 0, num = 0;
        for (int i = 0 ; i < words.length ; i ++) {
            if (words[i].length() > maxLength) {
                maxLength = words[i].length();
                num = i;
            }
        }
        System.out.println("Саммое длинное слово в строке: " + words[num] + ". Его длина " + maxLength + " символов.");
    }
}
