package probs1to10;

import util.numbers.Primes;

public class Prob7 {

    public static void main(String[] args) {
        long p = Primes.getNthPrime(10001);
        System.out.println(p);
    }
}
