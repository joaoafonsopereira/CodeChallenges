import static util.Maths.isMultiple;

public class Prob5 {

    static boolean divisibleBy1to20(int n) {
        for(int d = 2; d <= 20; d++) {
            if(!isMultiple(n, d))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int res = 2520;
        while(!divisibleBy1to20(res))
            res += 2;
        System.out.println(res);
    }
}
