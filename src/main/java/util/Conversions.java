package util;

public class Conversions {

    public static int[] toIntArray(String spaceSeparatedArray) {
        final int len = spaceSeparatedArray.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = spaceSeparatedArray.charAt(i) - '0';
        }
        return res;
    }

    public static int[] toIntArray(String[] strArr) {
        final int len = strArr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = Integer.parseInt(strArr[i]);
        }
        return res;
    }

    public static int[][] toIntMatrix(String[] strArr, int numCols) {
        final int len = strArr.length;
        final int numLines = len / numCols;
        int[][] res = new int[numLines][numCols];
        for (int i = 0; i < len; i++) {
            int l = i / numCols;
            int c = i % numCols;
            res[l][c] = Integer.parseInt(strArr[i]);
        }
        return res;
    }


}
