import java.util.*;

public class LargestNumber {
    private static String[] zeros = {"", "0", "00", "000", "0000", "00000"};
    private static String[] nines = {"", "9", "99", "999", "9999", "99999"};

    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        Arrays.sort(a, (o1, o2) -> {
            String tmpo1 = o1+o2;
            String tmpo2 = o2+o1;
            return tmpo2.compareTo(tmpo1);
        });
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

