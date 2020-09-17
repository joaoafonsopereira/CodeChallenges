/**
 * Problem 9 - Special Pythagorean triplet //
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *                                  a² + b² = c²
 * For example, 3² + 4² = 9 + 16 = 25 = 5².
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class Prob9 {

    /**
     * These values could be narrowed with a little effort; not worth it yet tho
     */
    static final int INIT_C = 5; // first pythagorean triplet
    static final int MAX_C = 997; // a < b < c => min values for a,b are 1,2 => c = 1000 - 2 - 1

    private static boolean isPerfectSquare(int n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) - sqrt == 0.0f;
    }

    public static void main(String[] args) {
        int SZ = 1000;

        // perfSquares[i] = i*i
        int[] perfSquares = new int[SZ];
        perfSquares[0] = 0;
        perfSquares[1] = 1;
        perfSquares[2] = 4;

        for (int c = INIT_C; c < MAX_C; c++) {
            perfSquares[c] = c * c;
            int accumDif = 0;
            // look for a and b such that: a < b < c && a² + b² = c²
            for (int b = c - 1; b > 0; b--) {
                // accumDif = c² - b²  => a = sqrt(accumDif)
                accumDif += perfSquares[b + 1] - perfSquares[b];
                if (accumDif >= perfSquares[c])
                    break;
                if (accumDif >= perfSquares[b])
                    // only looking for a < b
                    break;
                if (isPerfectSquare(accumDif)) {
                    int a = (int) Math.sqrt(accumDif);
                    if (a + b + c == 1000) {
                        System.out.println(a * b * c);
                        System.out.printf("a = %d, b = %d, c = %d\n", a, b, c);
                    }
                }
            }
        }


    }
}
