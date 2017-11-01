public class Task4 {
    public static void main(String[] args) {
        System.out.println(args[0].replaceAll("([\\,.\\s]+|^)\\w{1}([\\,.\\s]+|$)", " "));
    }
}
