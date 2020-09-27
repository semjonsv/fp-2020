import java.util.Set;
import java.util.HashSet;

public class PerfectNumber {

    public static Set<Integer> divisors(int n) {
        Set<Integer> numbers = new HashSet<>();

        for (int i = 1; i <= n; i++)
            if (n % i == 0) numbers.add(i);

        return numbers;
    }

    public static String process(int n) {
        Set<Integer> divisors = PerfectNumber.divisors(n);

        int number = 0;
        String status;

        for (int i : divisors)
            number += i != n ? i : 0;

        if (number == n)
            status = "perfect number";
        else if (number > n)
            status = "abundant number";
        else
            status = "deficient number";

        return status;
    }

    public static void detect(int n)
    {
        System.out.println(n + ": " + PerfectNumber.process(n));
    }

    public static void main(String[] args) {
        PerfectNumber.detect(6);
        PerfectNumber.detect(9);
        PerfectNumber.detect(100);
        PerfectNumber.detect(122);
        PerfectNumber.detect(8128);
    }

}
