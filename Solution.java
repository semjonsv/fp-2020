public class Solution {

    static long superDigit(long x) {
        if (x <= 0) return 0;

        long sum = (superDigit(x / 10) + x % 10);

        if (sum < 10) return sum;

        return superDigit(sum);
    }

    public static void main(String[] args) {
        long x = 9875;
        long digit = superDigit(x);

        if (digit == 0)
            System.out.println("There is no super digit for " + x);
        else
            System.out.println("Super digit of number " + x + " is " + superDigit(digit));
    }

}
