package util;

public class Maths {

    public static boolean isMultiple(int x, int y) {
        return (x % y) == 0;
    }

    // TODO: make isMultiple a generic method
    public static boolean isMultiple(long x, long y) {
        return (x % y) == 0;
    }

    public static boolean isEven(long x) {
        return isMultiple(x, 2);
    }

    public static boolean isPowerOf2(long x) {
        return (x & (x-1)) == 0;
    }

    public static boolean isPerfectSquare(long n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) - sqrt == 0.0f;
    }


    public static int max(int... args) {
        int max = Integer.MIN_VALUE;
        for (int a : args) {
            max = Math.max(a, max);
        }
        return max;
    }


}
