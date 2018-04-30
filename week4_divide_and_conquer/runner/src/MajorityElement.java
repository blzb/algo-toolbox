import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        int[] b = new int[a.length];
        return getMajorityElement(a, b, left, right);
    }

    private static int getMajorityElement(int[] a, int[] b, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        int middle = (left + right) / 2;
        int middleCount = (right - left) / 2;
        int leftMajority = getMajorityElement(a, b, left, middle);
        int rightMajority = getMajorityElement(a, b, middle, right);
        if (leftMajority == rightMajority) {
            return leftMajority;
        } else {
            int leftCount = 0;
            int rightCount = 0;
            for (int i = left; i < right; i++) {
                if (a[i] == leftMajority) {
                    leftCount++;
                } else if (a[i] == rightMajority) {
                    rightCount++;
                }
            }

            if (leftCount > middleCount) {
                return leftMajority;
            } else if (rightCount > middleCount) {
                return rightMajority;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = getMajorityElement(a, 0, a.length);
        if (result != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

