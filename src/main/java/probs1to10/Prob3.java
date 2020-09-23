package probs1to10;

import util.numbers.iterators.PrimesIterator;

import static util.numbers.Generic.isMultiple;

public class Prob3 {


    public static void main(String[] args) {

//        long N = 600851475143L;
        long N = 317584931803L;
        PrimesIterator pIt = new PrimesIterator();
        long nextPrime = pIt.next();

        while (N != 1) {
            while (!isMultiple(N, nextPrime))
                nextPrime = pIt.next();
            System.out.println(nextPrime);
            N = N / nextPrime;
        }
        System.out.println("\nLargest: " + nextPrime);
    }
}
