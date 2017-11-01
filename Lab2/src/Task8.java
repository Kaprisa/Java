public class Task8 {
    public static void main(String[] args) {
        String str = args[0];
        while (str.matches(".*\\([^\\(\\)]*\\).*")) {
            str = str.replaceAll("\\([^\\(\\)]*\\)", "");
        }
        if (str.contains("(") || str.contains(")")) System.out.println("Строка не корректна");
        else System.out.println("Строка корректна");
    }
}
