package util;

public class Util {

    public static int[] toIntArray(String[] strArr) {
        final int len = strArr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Integer.parseInt(strArr[i]);
        }
        return res;
    }

    public static int[] toIntArray(String spaceSeparatedArray) {
        final int len = spaceSeparatedArray.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = spaceSeparatedArray.charAt(i) - '0';
        }
        return res;
    }

}
