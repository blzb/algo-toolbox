import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        long previous = 0;
        long current  = 1;
        long period = 0;
        boolean found = false;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
            System.out.println(previous+ " " + current+" "+ i);
            if(previous==0 && current == 1){
                period = i;
                found = true;
                break;
            }
        }

        if (!found)
            return current;

        long traslated = n % (period+1);
        if (traslated <= 1)
            return traslated;
        previous = 0;
        current  = 1;
        for (long i = 0; i < traslated - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%m;
        }
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

