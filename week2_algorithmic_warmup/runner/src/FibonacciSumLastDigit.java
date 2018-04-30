import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {

        if(n<=1)
            return n;
        long previous = 0;
        long current  = 1;
        long period = 0;
        long sumPeriod= 1;
        boolean found = false;
        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            if(previous==0 && current == 1){
                period = i;
                found = true;
                break;
            }else {
                sumPeriod = (sumPeriod + current)%10;
            }
        }

        if (!found)
            return sumPeriod;

        long traslated = n % (period+1);
        long periods = n / (period+1);
        if(traslated<=1)
            return traslated;
        previous = 0;
        current  = 1;
        long sum = 1;
        for (int i = 0; i < traslated - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum = (sum + current)%10;
        }
        return (periods*sumPeriod + sum)%10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

