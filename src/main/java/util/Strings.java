package util;

public class Strings {

    public static String removeQuotMarks(String s) {
        return s.substring(1, s.lastIndexOf('"'));
    }

    public static int alphabeticalValue(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += s.charAt(i) - 'A' + 1;
        return sum;
    }

    public static String trailingZeros(String s) {
        int idx = s.length() - 1;
        while (s.charAt(idx) == '0')
            idx--;
        return s.substring(idx + 1);
    }
}
