import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PerfectNumberModified {

    public static Set<Integer> divisors(int n) {
        Set<Integer> numbers = new HashSet<>();

        IntStream.rangeClosed(1, (int) Math.sqrt(n))
                .filter(i -> n % i == 0)
                .forEach(i -> Collections.addAll(numbers, i, n/i));

        return numbers;
    }

    public static void detect(int n)
    {
        Set<Integer> divisors = PerfectNumberModified.divisors(n);

        int number = divisors.stream().filter(i -> n != i).mapToInt(Integer::intValue).sum();
        String status = number == n ? "perfect number" : (number > n ? "abundant number" : "deficient number");

        System.out.println(n + ": " + status);
    }

    public static void main(String[] args) {
        PerfectNumberModified.detect(6);
        PerfectNumberModified.detect(9);
        PerfectNumberModified.detect(100);
        PerfectNumberModified.detect(122);
        PerfectNumberModified.detect(8128);
    }

}
