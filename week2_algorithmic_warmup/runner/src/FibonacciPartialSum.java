import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long previous = 0;
        long current = 1;
        long period = 59;
        long sumPeriod = 1;

        long traslatedF = from % (period + 1);
        long traslatedT = to % (period + 1);
        previous = 0;
        current = 1;
        long sumF;
        long sumT;
        if (traslatedF <= 1) {
            sumF = 0;
        } else {
            sumF = 1;
        }
        if (traslatedT < 1) {
            sumT = 0;
        } else {
            sumT = 1;
        }

        for (int i = 0; i < Math.max(traslatedF, traslatedT) - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            if (i < (traslatedF - 2)) {
                sumF = (sumF + current) % 10;
            }
            if (i < traslatedT - 1) {
                sumT = (sumT + current) % 10;
            }

        }
        if (sumF > sumT) {
            sumT = sumT + 10;
        }
        return sumT - sumF;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

