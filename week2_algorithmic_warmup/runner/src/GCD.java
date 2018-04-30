import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int base = a;
    int current_gcd = b;
    while((base%current_gcd) != 0){
      int tmp = base%current_gcd;
      base=current_gcd;
      current_gcd=tmp;
    }

    return current_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
