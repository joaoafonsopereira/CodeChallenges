import java.util.Arrays;

public class Prob17 {


    public static void main(String[] args) {

        final String[] baseWords = {
                "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        final String[] baseTens = {
                "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        final int baseWordTotalLetters = Arrays.stream(baseWords)
                .mapToInt(String::length).reduce(0, Integer::sum);

        final int teensTotalLetters = Arrays.stream(teens)
                .mapToInt(String::length).reduce(0, Integer::sum);

        final int[] baseWordLens = Arrays.stream(baseWords)
                .mapToInt(String::length).toArray();

        final int[] baseTensLens = Arrays.stream(baseTens)
                .mapToInt(String::length).toArray();


        // [1, 19]
        final int totalLettersUnder20 = baseWordTotalLetters + teensTotalLetters;
        // [20, 99]
        final int totalLettersBetween20and99 = Arrays.stream(baseTensLens)
                .map(len -> len * 10 + baseWordTotalLetters).reduce(0, Integer::sum);

        // [1, 99]
        final int totalLettersUnder100 = totalLettersUnder20 + totalLettersBetween20and99;

        int totalLettersBetween100and999 = 0;
        for (int len : baseWordLens) {
            int hundredTotalLetters = len + "hundred".length();
            // <one/two/three/...> hundred and ...
            int hundredAndSomethingTotalLetters =
                    (hundredTotalLetters + "and".length()) * 99 + totalLettersUnder100;

            totalLettersBetween100and999 += hundredTotalLetters + hundredAndSomethingTotalLetters;
        }

        final int totalLettersUnder1000 = totalLettersUnder100 + totalLettersBetween100and999;
        final int totalLettersIncluding1000 = totalLettersUnder1000 + "onethousand".length();

        System.out.println(totalLettersIncluding1000);

    }
}
