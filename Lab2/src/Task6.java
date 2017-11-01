public class Task6 {
    public static void main(String[] args) {
       int year = Integer.parseInt(args[0].replaceAll("\\D", ""));
       if (year < 100) year = 1900 + year;
       if (year < 1000) year = 1000 + year;
       if (year >= 10000) year = Math.round(year/10);
       System.out.println(year);
    }
}
