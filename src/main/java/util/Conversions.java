package util;

public class Conversions {

    public static int[] toIntArray(String arrayAsString) {
        final int len = arrayAsString.length();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arrayAsString.charAt(i) - '0';
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

    public static int[][] parseTriangle(String triangle) {
        final String[] lines = triangle.split("\n");
        final int nLines = lines.length;

        int[][] res = new int[nLines][nLines];
        for(int i = 0; i < nLines; i++) {
            String line = lines[i];
            String[] tokens = line.split(" ");
            for(int j = 0; j <= i; j++) {
                res[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        return res;
    }

}
