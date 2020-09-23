package probs1to10;

public class Prob2 {

    public static void main(String[] args) {

        int fn2 = 0;
        int fn1 = 1;
        int fn = fn1 + fn2;
        int sum = 0;

        while(fn < 4000000) {
            fn = fn1 + fn2;
            if(fn % 2 == 0)
                sum += fn;
            fn2 = fn1;
            fn1 = fn;
        }
        System.out.println(sum);
    }

}
