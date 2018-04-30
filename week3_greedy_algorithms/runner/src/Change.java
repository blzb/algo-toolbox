import java.util.Scanner;

public class Change {
    private static long getChange(int m) {
        //write your code here
        long rem = m;
        long ten = rem / 10;
        rem = rem % 10;
        long five = rem / 5;
        rem = rem % 5;
        return ten + five + rem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

