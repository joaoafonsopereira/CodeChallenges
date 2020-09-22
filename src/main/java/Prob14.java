import util.numbers.Generic;

public class Prob14 {

    static final int LIMIT = 1000000;

    static long nextCollatz(long n) {
        if(Generic.isEven(n))
            return n/2;
        return 3*n + 1;
    }

    static int collatzSeqLen(int n, int[] lens) {
        if(lens[n] > 0)
            return lens[n];

        long currCollatz = n;
        int counter = 1;
        while(currCollatz != 1) {
            if(currCollatz < LIMIT){
                int currCollatzSeqLen = lens[(int) currCollatz];
                if(currCollatzSeqLen > 0) {
                    counter += currCollatzSeqLen;
                    break;
                }
            }
            currCollatz = nextCollatz(currCollatz);
            counter++;
        }
        lens[n] = counter;
        return counter;
    }

    public static void main(String[] args) {
        double start = System.nanoTime();

        int[] lens = new int[LIMIT+1];
        lens[1] = 1;
        int maxLen = 1;
        long oDitoCujo = 1;
        for(int i = 2; i < LIMIT; i++) {
            int seqLen = collatzSeqLen(i, lens);
            if(seqLen > maxLen) {
                maxLen = seqLen;
                oDitoCujo = i;
            }
        }
        System.out.println(oDitoCujo);
        System.out.println(maxLen);

        double time = (System.nanoTime() - start) * 1.0 / 1000000000;
        System.out.println("Time = " + time + "s");
    }
}
