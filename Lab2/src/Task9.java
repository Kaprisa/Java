public class Task9 {
    public static void main(String[] args) {
        String[] ranges = args[0].replaceAll("\\s", "").split(",");
        for (int i = 0 ; i < ranges.length; i ++) {
            if (ranges[i].contains("-")) {
                for (int k = Integer.parseInt(ranges[i].substring(0, ranges[i].indexOf("-"))); k <= Integer.parseInt(ranges[i].substring(ranges[i].indexOf("-") + 1,ranges[i].length())) ; k ++) {
                    System.out.print(k + " ");
                }
            } else System.out.print(ranges[i] + " ");
        }
    }
}
