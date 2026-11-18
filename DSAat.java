import java.util.Arrays;

public class DSAat {
    static void printPrimes(int limit) {
        if (limit < 2) {
            return;
        }

        boolean[] prime = new boolean[limit + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int number = 2; number <= limit / number; number++) {
            if (prime[number]) {
                for (long multiple = (long) number * number;
                     multiple <= limit;
                     multiple += number) {

                    prime[(int) multiple] = false;
                }
            }
        }

        for (int number = 2; number <= limit; number++) {
            if (prime[number]) {
                System.out.print(number + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        printPrimes(30);
    }
}