package probs1to10;

public class Prob1 {

    static boolean isMultiple(int x, int y) {
        return (x % y) == 0;
    }

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1000; i++) {
            if(isMultiple(i, 3) || isMultiple(i, 5))
                sum += i;
        }
        System.out.println(sum);
    }

}
