import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        int firstIndex = 0;
        int secondIndex = -1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > numbers[firstIndex]) {
                firstIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != firstIndex) {
                if (secondIndex == -1 || numbers[i] > numbers[secondIndex]) {
                    secondIndex = i;
                }
            }
        }
        long first = numbers[firstIndex];
        long second = numbers[secondIndex];
        return first * second;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}