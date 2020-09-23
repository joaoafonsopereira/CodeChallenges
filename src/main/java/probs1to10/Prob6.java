package probs1to10;

public class Prob6 {

    public static void main(String[] args) {
        int sumOfSquares = 0;
        int squareOfSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum *= squareOfSum;
        int dif = squareOfSum - sumOfSquares;
        System.out.println("Dif = " + dif);
    }
}
