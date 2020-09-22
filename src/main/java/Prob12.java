import util.numbers.Generic;
import util.numbers.iterators.TriangleNbrIterator;

import java.util.Iterator;


public class Prob12 {

    // Como contar nº de divisores de x?
    //
    // -> Obter lista de factors de x na forma:
    //          x = a^p * b^q * c^r * d^s * e^t * ...
    // -> nº de divisores de x é dado por (p+1)*(q+1)*(r+1)*(s+1)*(t+1)


    static int nDivisors(long nr) {
        int nDivs = 2; // 1 and nr
        for (int i = 2; i < Math.sqrt(nr); i++) {
            if (Generic.isMultiple(nr, i))
                nDivs += 2; // i and nr/i
        }
        if (Generic.isPerfectSquare(nr))
            nDivs++;
        return nDivs;
    }


    public static void main(String[] args) {
        double start = System.nanoTime();

        Iterator<Long> trianglesIt = new TriangleNbrIterator();
        while (true) {
            long triang = trianglesIt.next();
            if (nDivisors(triang) >= 500) {
                System.out.println(triang);
                break;
            }
        }

        double time = (System.nanoTime() - start) * 1.0 / 1000000000;
        System.out.println("Time = " + time + "s");
    }

}



