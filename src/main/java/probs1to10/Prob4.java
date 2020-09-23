package probs1to10;

public class Prob4 {

    static boolean isPalindrome(int n) {
        char[] str = String.valueOf(n).toCharArray();
        int len = str.length;
        for (int i = 0; i < len / 2; i++) {
            if (str[i] != str[len - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int largestPalindr = 0;
        for (int i = 999; i >= 100; i--) {
            if ((i * (i - 1)) < largestPalindr)
                break;
            for (int j = i - 1; j >= 100; j--) {
                int prod = i * j;
                if(prod < largestPalindr)
                    break;
                if (isPalindrome(prod))
                    if (prod > largestPalindr)
                        largestPalindr = prod;
            }
        }
        System.out.println(largestPalindr);

    }
}
