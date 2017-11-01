package mathematics;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static Double calc(String str) {
        str=str.toLowerCase().replaceAll(" ", "").replaceAll(",", ".");
        Pattern p = Pattern.compile("\\([^\\(\\)]*\\)");
        Matcher m = p.matcher(str);
        while(m.find()) {
            str = str.substring(0, m.start()) + calc(str.substring(m.start() + 1, m.end() - 1)) + str.substring(m.end());
            m.reset(str);
        }
        str = str.replaceAll("\\+-", "-");
        str = str.replaceAll("--", "+");
        str = str.replaceAll("(exp|e)", "2.72");
        str = str.replaceAll("pi", "3.14");
        if (str.matches(".*[a-z]+.*")) str = replaceFunctions(str);
        str = replaceOperations(str, "^-");
        str = replaceOperations(str, "*-");
        str = replaceOperations(str, "/-");
        str = replaceOperations(str, "^");
        str = replaceOperations(str, "*");
        str = replaceOperations(str, "/");
        str = replaceOperations(str, "+");
        str = replaceOperations(str, "-");
        return Double.parseDouble(str);
    }

    private static String numRegexp = "[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";

    private static String replaceOperations(String str, String operator) {

        Pattern p = Pattern.compile(String.format("%s\\%s{1}%s", numRegexp, operator, numRegexp));
        Matcher m = p.matcher(str);
        while(m.find()) {
            str = str.substring(0, m.start()) + count(str.substring(m.start(), m.end()), operator) + str.substring(m.end());
            m.reset(str);
        }
        return str;
    }

    private static Double count(String str, String operator) {
        String[] stringNumbers = str.split( String.format("\\%s", operator));
        double[] numbers = new double[2];
        numbers[0] = Double.parseDouble(stringNumbers[0]);
        numbers[1] = Double.parseDouble(stringNumbers[1]);
        switch (operator) {
            case "^-": return Math.pow(numbers[0], -numbers[1]);
            case "*-": return numbers[0] * (-numbers[1]);
            case "/-": return numbers[0] / (-numbers[1]);
            case "^": return Math.pow(numbers[0], numbers[1]);
            case "*": return numbers[0] * numbers[1];
            case "/": return numbers[0] / numbers[1];
            case "+": return numbers[0] + numbers[1];
            case "-": return numbers[0] - numbers[1];
            default: return 0.0;
        }
    }
    private static String replaceFunctions(String str) {
        Pattern p = Pattern.compile(String.format("[a-z]+-?%s", numRegexp));
        Matcher m = p.matcher(str);
        while(m.find()) {
            str = str.substring(0, m.start()) + countFunction(str.substring(m.start(), m.end())) + str.substring(m.end());
            m.reset(str);
        }
        return str;
    }
    private static Double countFunction(String str) {
        double num = Double.parseDouble(str.replaceFirst("[a-z]+", ""));
        String f = str.replaceFirst(numRegexp, "");
        switch (f) {
            case "arcsin": { num = Math.asin(num); break; }
            case "arccos": { num = Math.acos(num); break; }
            case "asin": { num = Math.asin(num); break; }
            case "acos": { num = Math.acos(num); break; }
            case "arctg": { num = Math.atan(num); break; }
            case "arcctg": { num = Math.PI/2 - Math.atan(num); break; }
            case "sin": { num = Math.sin(num); break; }
            case "cos": { num = Math.cos(num); break; }
            case "tg": { num = Math.tan(num); break; }
            case "ctg": { num = 1 / Math.tan(num); break; }
            case "abs": { num = Math.abs(num); break; }
            case "sqrt": { num = Math.sqrt(num); break; }
            case "sqr": { num = Math.pow(num, 2); break; }
            case "ln": { num = Math.log(num); break; }
            case "log": { num = Math.log10(num); break; }
            case "sh": { num = Math.sinh(num); break; }
            case "ch": { num = Math.cosh(num); break; }
        }
        return ((double) Math.round(num * 100))/100;
    }
}

